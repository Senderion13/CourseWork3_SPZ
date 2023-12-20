import { Controller, Get, Query } from '@nestjs/common';
import { ApiService } from './api.service';

@Controller('api')
export class ApiController {
  @Get('name')
  getUserName(@Query('token') token: string) {
    return ApiService.prototype.getUserName(token);
  }
  @Get('bio')
  getUserBio(@Query('token') token: string) {
    return ApiService.prototype.getUserBio(token);
  }
}
