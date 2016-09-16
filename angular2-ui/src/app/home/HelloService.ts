import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class HelloService {

  constructor(private _http: Http) {}

  getHello() {
    return this._http.get('http://localhost:8090/test')
      .map((res:Response) => res.json());
  }
}
