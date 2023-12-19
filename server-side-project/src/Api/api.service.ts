import { Injectable } from '@nestjs/common';

@Injectable()
export class ApiService {
  getUserName(token: string) {
    return token + ' name';
  }
  getUserIcon(token: string) {
    return token + ' icon';
  }
  getUserBio(token: string) {
    return token + ' bio';
  }
}
