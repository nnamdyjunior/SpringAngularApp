import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  private getPlayersUrl = '/realmadrid/players/get';
  private postUrl = '/realmadrid/players/add';

  constructor(private httpClient:HttpClient) { }

  savePlayer = (player:Player) => {
    console.log('look, Im flying!!!', this.postUrl);
    const test = this.httpClient.put(this.postUrl, player) as Observable<Player>;
    console.log('Crashed!!!', test);
    return test;
  };

  getPlayers = () => this.httpClient.get(this.getPlayersUrl) as Observable<Player[]>

}

export interface Player {
  name: string
  age: number
  games: number
  goals: number
}
