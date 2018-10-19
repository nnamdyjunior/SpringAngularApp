import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import {Player, PlayerService} from "./service/player.service";
import {of} from "rxjs";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import any = jasmine.any;
import {By} from "@angular/platform-browser";

describe('AppComponent', () => {
  let fixture;
  let component;
  let playerService;

  beforeEach(async(() => {
    fixture = TestBed.configureTestingModule({
      imports: [FormsModule, HttpClientModule],
      providers:[PlayerService, HttpClientModule],
      declarations: [
        AppComponent
      ],
    }).createComponent(AppComponent);

    component = fixture.componentInstance;
    playerService = TestBed.get(PlayerService)
  }));

  it('fetches player list on init', () => {
    let getPlayersSpy = spyOn(playerService, 'getPlayers').and.returnValue(of([]));
    fixture.detectChanges();
    expect(getPlayersSpy).toHaveBeenCalled();
  });

  it('saves player on submit', () => {
    let savePlayerSpy = spyOn(playerService, 'savePlayer').and.returnValue(of(any));
    let player:Player = {name:'Nnamdy', age:27, games:100, goals:200};
    component.savePlayer(player);
    expect(savePlayerSpy).toHaveBeenCalledWith(player);
  });

  it('populates table with players on init', () => {
    let players: Player[] = [{name:"James Rodriguez", age:28, games: 100, goals: 21}];
    component.players = players;

    fixture.detectChanges();

    // let tableRow = fixture.debugElement.query(By.css('#playerNameRow'));
    let tableRow = fixture.nativeElement.querySelector('#playerNameRow');
    expect(tableRow.outerHTML).toContain('James Rodriguez');
  });
});
