import {Component, OnInit} from '@angular/core';
import {Player, PlayerService} from "./service/player.service";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {State} from "./reducers";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  player: Player = {name: '', age: 0, games: 0, goals: 0};
  players: Observable<Player[]>;
  myPlayers: Player[];
  columns: string[] = ['NAME', 'AGE', 'GAMES', 'GOALS'];

  // constructor(private playerService: PlayerService) {
  // }
  //
  constructor(private store:Store<any>) {
    // this.players = store.select('playerReducer')
  }

  ngOnInit() {
    // this.playerService.getPlayers()
    //   .subscribe(result => this.players = result);
    this.players = this.store.select('playerReducer');
    this.players.subscribe(pl => this.myPlayers = pl)
  }
  //
  // savePlayer = (player: Player) => {
  //   this.playerService.savePlayer(player)
  //     .subscribe(result => console.log(result));
  //
  // }

  savePlayer = (data:Player) => {
    this.store.dispatch({
      type: 'ADD_PLAYER',
      payload: data
    });
  }

}

