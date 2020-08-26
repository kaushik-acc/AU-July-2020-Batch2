import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import{ FormGroup,FormControl, Validators,ReactiveFormsModule} from '@angular/forms';
import { User } from "../user.model";
import {UserDataService} from '../user-data.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit,OnDestroy {
  profileForm = new FormGroup({
    firstName: new FormControl('',[Validators.required,
      Validators.minLength(3)]),
    lastName: new FormControl(''),
    address: new FormGroup({
      street: new FormControl(''),
      city: new FormControl('',[Validators.required]),
      state: new FormControl('',[Validators.required]),
      pin: new FormControl('',[Validators.required,Validators.pattern('^[1-9]{1}[0-9]{2}[0-9]{3}$')])
    })
  });
  

 
  constructor(private userData: UserDataService) { 
    
  }

  ngOnInit(): void {
      
  }
  
  ngOnDestroy(): void{
    
    const newUser=new User(this.profileForm.value['firstName'],
    this.profileForm.value['lastName'],
    this.profileForm.value['address']['street'],
    this.profileForm.value['address']['city'],
    this.profileForm.value['address']['state'],
    this.profileForm.value['address']['pin']
    )
    
    this.userData.addUser(newUser);
    
  }
  onSubmit(): void {
    
    
  }

}
