import { Component, OnInit } from "@angular/core";
import { SpringService } from "../spring.service";

@Component({
  selector: "app-rules",
  templateUrl: "./rules.component.html",
  styleUrls: ["./rules.component.css"]
})
export class RulesComponent implements OnInit {
  constructor(private springService: SpringService) {}

  ngOnInit() {}

  OnClickStartGame() {
    this.springService.startGame().subscribe();
  }
}
