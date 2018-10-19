import { TestBed, inject } from '@angular/core/testing';

import {Player, PlayerService} from './player.service';
import {AppComponent} from "../app.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

describe('PlayerService', () => {
  let fixtures;
  let component;
  let playerService: PlayerService;

  beforeEach(() => {
    component = TestBed.configureTestingModule({
      imports: [FormsModule, HttpClientModule],
      providers: [PlayerService, HttpClientModule],
      declarations: [AppComponent]
    }).createComponent(AppComponent);

    fixtures = component.componentInstance;

    playerService = TestBed.get(PlayerService)
  });

  it('should be created', inject([PlayerService], (service: PlayerService) => {
    expect(service).toBeTruthy();
  }));

  it('makes a request to the server', () => {
    let player:Player;
    player = {name:'Modric', age: 32, games: 300, goals: 25};

    spyOn(playerService, 'savePlayer').and.callThrough();

    fixtures.savePlayer(player);
    expect(playerService.savePlayer).toHaveBeenCalledWith(player);
  });

  it('gets a list of players from the server when user requests', () => {
    spyOn(playerService, 'getPlayers').and.callThrough();

    fixtures.ngOnInit();
    expect(playerService.getPlayers).toHaveBeenCalled()
  })
});
