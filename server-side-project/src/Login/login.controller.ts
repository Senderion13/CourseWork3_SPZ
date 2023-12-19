import { Controller, Get, Query } from '@nestjs/common';
import { LoginService } from './login.service';

@Controller('login')
export class LoginController {
  @Get()
  Login(@Query('user') user: string, @Query('pass') pass: string) {
    return LoginService.prototype.Login(user, pass);
  }
}
