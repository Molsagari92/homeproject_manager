import { Component, OnInit } from "@angular/core";
import { SpringService } from "../spring.service";

@Component({
  selector: "app-menu",
  templateUrl: "./menu.component.html",
  styleUrls: ["./menu.component.css"]
})
export class MenuComponent implements OnInit {
  constructor(private springService: SpringService) {}

  ngOnInit() {}
  OnClickStartGame() {
    this.springService.startGame().subscribe();
  }
}
