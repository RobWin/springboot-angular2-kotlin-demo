import {Component, OnInit, OnDestroy} from '@angular/core';
import {Router} from '@angular/router';

import {Hero} from '../../domain/Hero';
import {HeroesService} from '../../services/HeroesService';


@Component({
  selector: 'heros',
  styleUrls: ['./heroes.css'],
  templateUrl: './heroes.html',
  providers: [HeroesService]
})
export class HeroesComponent implements OnInit, OnDestroy{
  // vars
  hero: Hero = {
    id: 1,
    name: 'Windstorm'
  };

  heroes: Hero[];

  selectedHero: Hero;

  // constructor
  constructor(private heroesService: HeroesService,
              private router: Router) { }


  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedHero.id]);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.heroesService.create(name)
      .then(hero => {
        this.heroes.push(hero);
        this.selectedHero = null;
      });
  }

  delete(hero: Hero): void {
    this.heroesService
      .delete(hero.id)
      .then(() => {
        this.heroes = this.heroes.filter(h => h !== hero);
        if (this.selectedHero === hero) { this.selectedHero = null; }
      });
  }

  // on-init
  ngOnInit() {
    this.heroesService.getHeroes().then(heroes => this.heroes = heroes);
  }

  // on-destroy
  ngOnDestroy() {

  }
}
