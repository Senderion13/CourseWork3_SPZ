import { Injectable } from '@nestjs/common';
import * as json from '../../database.json';
import { userDto } from './user.dto';
@Injectable()
export class ApiService {
  getUserName(token: string) {
    const usersList: userDto[] = json.users;
    return usersList.find((user: userDto) => {
      if (token == user.token) {
        return true;
      } else {
        return false;
      }
    }).name;
  }
  getUserBio(token: string) {
    const usersList: userDto[] = json.users;
    return usersList.find((user: userDto) => {
      if (token == user.token) {
        return true;
      } else {
        return false;
      }
    }).bio;
  }
}
