import {Routes} from '@angular/router';
import {HeroesComponent} from './../components/heros/HeroesComponent';
import {DashboardComponent} from './../components/dashboard/DashboardComponent';
import {HeroDetailComponent} from './../components/hero-details/HeroDetailComponent';

export const AppRoutes: Routes = [
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {path: 'heroes', component: HeroesComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'detail/:id', component: HeroDetailComponent}
];
