import { Injectable } from '@nestjs/common';

const users = [
  { name: 'andrey', pass: '12345' },
  { name: 'alexey', pass: 'qwerty' },
];

export let token;

@Injectable()
export class LoginService {
  Login(userName: string, userPass: string): string {
    if (
      users.find(({ name, pass }) => {
        if (userName == name && userPass == pass) {
          console.log(name, pass);
          return true;
        }
      })
    ) {
      token = rand();
      return token;
    } else {
      return '';
    }
  }
}
const rand = () => {
  return Math.random().toString(36).substr(2);
};
