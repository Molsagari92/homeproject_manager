import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { RouterModule, Routes } from "@angular/router";
import { GameComponent } from "./game/game.component";
import { RulesComponent } from "./rules/rules.component";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { ResponseHttpInterceptor } from "./response.interceptor";
import { MenuComponent } from "./menu/menu.component";
import { CreditComponent } from "./credit/credit.component";
import { WinnerComponent } from './winner/winner.component';
import { LoserComponent } from './loser/loser.component';

const route: Routes = [
  { path: "", component: MenuComponent },
  { path: "rules", component: RulesComponent },
  { path: "game", component: GameComponent },
  { path: "credit", component: CreditComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    RulesComponent,
    GameComponent,
    MenuComponent,
    CreditComponent,
    WinnerComponent,
    LoserComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(route),
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ResponseHttpInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
