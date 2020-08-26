import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from "../user.model";
import {UserDataService} from '../user-data.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit,OnDestroy {


  user: User;


  constructor(private userData: UserDataService) {

  }

  ngOnInit() {
    
    
    this.user=this.userData.user;
    
  }
  

  ngOnDestroy() {
    
  }




}
