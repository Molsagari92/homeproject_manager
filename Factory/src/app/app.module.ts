import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { RouterModule, Routes } from "@angular/router";
import { GameComponent } from "./game/game.component";
import { RulesComponent } from "./rules/rules.component";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { ResponseHttpInterceptor } from "./response.interceptor";

const route: Routes = [
  { path: "", component: RulesComponent },
  { path: "game", component: GameComponent }
];

@NgModule({
  declarations: [AppComponent, RulesComponent, GameComponent],
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
