import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class SpringService {
  constructor(private httpClient: HttpClient) {}

  getBasics() {
    return this.httpClient.get("http://localhost:8081/api/game/getbasics");
  }

  getMaterials(): Observable<number[]> {
    return this.httpClient.get<number[]>(
      "http://localhost:8081/api/game/getmaterials"
    );
  }

  getProducts(): Observable<number[]> {
    return this.httpClient.get<number[]>(
      "http://localhost:8081/api/game/getproducts"
    );
  }

  getProductPrices(): Observable<number[]> {
    return this.httpClient.get<number[]>(
      "http://localhost:8081/api/game/productprices"
    );
  }

  getMaterialPrices(): Observable<number[]> {
    return this.httpClient.get<number[]>(
      "http://localhost:8081/api/game/materialprices"
    );
  }

  getMessages(): Observable<string[]> {
    return this.httpClient.get<string[]>(
      "http://localhost:8081/api/game/messages"
    );
  }

  startTurn() {
    return this.httpClient.get("http://localhost:8081/api/game/startturn");
  }

  endTurn() {
    return this.httpClient.get("http://localhost:8081/api/game/endturn");
  }

  sendSell(sellInfo) {
    return this.httpClient.post(
      "http://localhost:8081/api/game/sellproduct",
      sellInfo
    );
  }

  sendProduce(produceInfo) {
    return this.httpClient.post(
      "http://localhost:8081/api/game/createproduct",
      produceInfo
    );
  }

  buyMaterial(materialInfo) {
    return this.httpClient.post(
      "http://localhost:8081/api/game/buymaterial",
      materialInfo
    );
  }

  hireWorker() {
    return this.httpClient.get("http://localhost:8081/api/game/hireworker");
  }

  fireWorker() {
    return this.httpClient.get("http://localhost:8081/api/game/fireworker");
  }

  //post-hoz így tudok küldeni adatot BODYban
  //postTest() {
  //return this.httpClient.post(
  //"http://localhost:8081/api/game/sellproduct",
  //{}
  //);
  //}
}
