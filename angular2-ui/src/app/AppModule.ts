//Imports
import {NgModule} from '@angular/core'
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
//Declarations
import {AppRoutes} from "./routing/AppRoutes";
import {AppComponent} from "./components/app/AppComponent";
import {HeroDetailComponent} from "./components/hero-details/HeroDetailComponent";
import {DashboardComponent} from "./components/dashboard/DashboardComponent";
import {HeroesComponent} from './components/heros/HeroesComponent';
import {HeroesService} from './services/HeroesService';

@NgModule({
  declarations: [AppComponent, HeroDetailComponent, HeroesComponent, DashboardComponent],
  imports     : [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(AppRoutes)],
  providers: [HeroesService],
  bootstrap   : [AppComponent]
})
export class AppModule {

}
