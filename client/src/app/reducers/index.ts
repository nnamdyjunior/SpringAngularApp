import {
  Action,
  ActionReducer,
  ActionReducerMap,
  createFeatureSelector,
  createSelector,
  MetaReducer
} from '@ngrx/store';
import { environment } from '../../environments/environment';
import {Actions, Effect, ofType} from "@ngrx/effects";
import {Player, PlayerService} from "../service/player.service";
import {Injectable} from "@angular/core";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";

export interface State {
}

export interface PlayerAction extends Action{
  type: string,
  payload: Player
}

// @Injectable() export class PlayerActions {
//   savePlayer(player): PlayerAction{
//     return{
//       type:'ADD_PLAYER',
//       payload: player
//     };
//   }
// }

@Injectable() export class PlayerEffects{

  constructor(private actions:Actions, private playerService: PlayerService) {
  }

  @Effect() savePlayer$:Observable<any> = this.actions
                              .pipe(
                                ofType('ADD_PLAYER'),
                                map(action => {
                                  console.log('action = ', action);
                                  console.log('actions = ', this.actions);
                                  this.playerService.savePlayer((action as PlayerAction).payload);
                                  // return {type:'DO_NOTHING'}
                                  return {type:'DO_NOTHING', payload: (action as PlayerAction).payload}
                                }));

}

export const playerReducer = (players:Player[] = [], action:PlayerAction):Player[] => {
  if(action.type === 'ADD_PLAYER'){
    console.log('adding player');
    return [...players, action.payload]
  } else {
    console.log('no new players!');
    return players
  }
};

export const reducers: ActionReducerMap<State> = {
  playerReducer
};


export const metaReducers: MetaReducer<Player[]>[] = !environment.production ? [] : [];
