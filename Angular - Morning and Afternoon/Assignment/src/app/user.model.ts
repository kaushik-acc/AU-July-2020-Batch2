export class User {
    public firstName: string;
    public lastName: string;
    public street: string;
    public city: string;
    public state: string;
    public pin: number;

    constructor(firstName: string, lastName: string, street: string, city: string,state: string,pin:number) {
      this.firstName=firstName;
      this.lastName=lastName;
      this.street = street;
      this.city = city;
      this.state=state;
      this.pin=pin;
      
    }
}
