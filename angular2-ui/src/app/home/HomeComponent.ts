import {Component, OnInit, OnDestroy} from '@angular/core';
import { HelloService } from './HelloService';

@Component({
  selector: 'home',
  styleUrls: ['./home.css'],
  templateUrl: './home.html',
  providers: [HelloService]
})
export class HomeComponent implements OnInit, OnDestroy{

  // vars
  private jsonResponse: string;
  private message: string;
  private _subscription;

  // constructor
  constructor(private _helloService: HelloService) {}

  // on-init
  ngOnInit() {
    // save _subscription
    this._subscription = this._helloService.getHello()
      .subscribe(
        (data) => {
          this.jsonResponse = JSON.stringify(data);
          this.message = data.message;
        },
        (err) => console.log(err),
        () => console.log('hello service test complete')
      );
  }

  // on-destroy
  ngOnDestroy() {
    // unsubscribe
    this._subscription.unsubscribe();
  }
}
