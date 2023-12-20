import { Injectable } from '@nestjs/common';
import * as json from '../../database.json';
//import * as fs from 'fs';

@Injectable()
export class LoginService {
  Login(userName: string, userPass: string): string {
    let tempToken: string;

    const index = json.users.findIndex(({ name, password }) => {
      if (userName == name && userPass == password) {
        tempToken = rand();
        return true;
      }
    });
    if (index >= 0) {
      json.users[index].token = tempToken;
      //fs.writeFileSync('./database.json', JSON.stringify(json), 'utf-8');
      return tempToken;
    } else {
      return '';
    }
  }
}
const rand = () => {
  return Math.random().toString(36).substr(2);
};
