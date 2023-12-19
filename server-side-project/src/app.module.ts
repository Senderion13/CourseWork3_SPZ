import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ApiController } from './Api/api.controller';
import { LoginController } from './Login/login.controller';

@Module({
  imports: [],
  controllers: [AppController, LoginController, ApiController],
  providers: [AppService],
})
export class AppModule {}
