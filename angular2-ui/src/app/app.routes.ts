import {Routes} from '@angular/router';
import {HomeComponent} from './home/HomeComponent';

export const rootRouterConfig: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent}
];

