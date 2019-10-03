import { Component, OnInit } from "@angular/core";
import { SpringService } from "../spring.service";
import { Observable, forkJoin } from "rxjs";
import { RouteConfigLoadEnd, Router } from "@angular/router";

@Component({
  selector: "app-game",
  templateUrl: "./game.component.html",
  styleUrls: ["./game.component.css"]
})
export class GameComponent implements OnInit {
  constructor(private springService: SpringService, private router: Router) {}

  data: any = [];
  materials: number[] = [];
  products: number[] = [];
  history: string[] = [];
  pprice: number[] = [];
  mprice: number[] = [];

  buyAmount: string;
  buyName: string;

  materialInfo = {
    name: this.buyName,
    amount: this.buyAmount
  };

  sellName: string;
  sellPrice: number;
  sellAmount: number;

  sellInfo = {
    name: this.sellName,
    price: this.sellPrice,
    amount: this.sellAmount
  };

  produceName: string;
  produceAmount: number;

  produceInfo = {
    name: this.produceName,
    amount: this.sellAmount
  };

  ngOnInit() {
    this.GetData();
  }

  GetData() {
    forkJoin(
      this.springService.getBasics(),
      this.springService.getMaterials(),
      this.springService.getProducts(),
      this.springService.getMessages(),
      this.springService.getProductPrices(),
      this.springService.getMaterialPrices()
    ).subscribe(([data, materials, products, messages, pprice, mprice]) => {
      this.data = data;
      this.materials = materials;
      this.products = products;
      this.history = messages;
      this.pprice = pprice;
      this.mprice = mprice;
    });
  }

  OnClickAdd() {
    this.springService.hireWorker().subscribe(val => {
      this.data[0] = val[0];
      this.data[2] = val[1];
      this.springService
        .getMessages()
        .subscribe(messages => (this.history = messages));
    });
  }

  OnClickDelete() {
    this.springService.fireWorker().subscribe(val => {
      this.data[0] = val[0];
      this.data[2] = val[1];
      this.springService
        .getMessages()
        .subscribe(messages => (this.history = messages));
    });
  }

  OnClickSell() {
    this.springService.sendSell(this.sellInfo).subscribe(number => {
      this.data[1] = number;
      this.GetData();
    });
  }

  OnClickProduce() {
    this.springService.sendProduce(this.produceInfo).subscribe(number => {
      this.data[2] = number;
      this.GetData();
    });
  }

  OnClickBuy() {
    this.springService.buyMaterial(this.materialInfo).subscribe(number => {
      this.data[1] = number;
      this.data[1] = this.data[1];
      this.springService
        .getMaterials()
        .subscribe(materials => (this.materials = materials));
      this.springService
        .getMessages()
        .subscribe(messages => (this.history = messages));
    });
  }

  OnClickStartGame() {
    this.springService.startGame().subscribe();
  }

  OnClickEndTurn() {
    this.springService
      .endTurn()
      .subscribe(() =>
        this.springService
          .startTurn()
          .subscribe(() =>
            this.springService.getMessages().subscribe(() => this.GetData())
          )
      );
  }

  IsWinner() {
    if (this.data[1] >= 2000000) {
      alert("Congratulation, you won! :)");
    }
  }

  IsLoser() {
    if (this.data[1] <= 0) {
      alert("You lost! :(");
    }
  }
}
