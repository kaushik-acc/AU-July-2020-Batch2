import { Injectable } from '@angular/core';
import { User } from "./user.model";
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  constructor() { }

  user:User;

    addUser(user: User){
        this.user=user;
           
    }
}
