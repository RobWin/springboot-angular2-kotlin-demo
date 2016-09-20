import {Component, Input, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';

import {HeroesService} from '../../services/HeroesService';
import {Hero} from '../../domain/Hero';

@Component({
  selector: 'hero-detail',
  styleUrls: ['./hero-detail.css'],
  templateUrl: './hero-detail.html',
  providers: [HeroesService]
})
export class HeroDetailComponent implements OnInit{
  @Input()
  hero: Hero;

  constructor(private heroesService: HeroesService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.forEach((params: Params) => {
      let id = parseInt(params['id']);
      this.heroesService.getHero(id)
        .then(hero => this.hero = hero);
    });
  }

  goBack(): void {
    window.history.back();
  }

  save(): void {
    this.heroesService.update(this.hero)
      .then(this.goBack);
  }
}
