import {Component, OnInit, OnDestroy} from '@angular/core';
import {Router} from '@angular/router';

import {Hero} from '../../domain/Hero';
import {HeroesService} from '../../services/HeroesService';

@Component({
  selector: 'dashboard',
  styleUrls: ['./dashboard.css'],
  templateUrl: './dashboard.html',
  providers: [HeroesService]
})
export class DashboardComponent implements OnInit {

  heroes: Hero[] = [];

  constructor(private heroesService: HeroesService,
              private router: Router) { }

  ngOnInit(): void {
    this.heroesService.getHeroes()
      .then(heroes => this.heroes = heroes.slice(0, 4));
  }

  gotoDetail(hero: Hero): void {
    let link = ['/detail', hero.id];
    this.router.navigate(link);
  }
}
