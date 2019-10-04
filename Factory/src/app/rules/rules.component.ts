import { Component, OnInit } from "@angular/core";
import { SpringService } from "../spring.service";
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-rules",
  templateUrl: "./rules.component.html",
  styleUrls: ["./rules.component.css"]
})
export class RulesComponent implements OnInit {
  constructor(
    private springService: SpringService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {}

  OnClickStartGame() {
    this.springService.startGame().subscribe();
  }
}
