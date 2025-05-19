import { Module } from '@nestjs/common';
import { ConfigModule, ConfigService } from '@nestjs/config';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { MongooseModule } from '@nestjs/mongoose';
import { UrlShortenerModule } from './modules/url-shortener/url-shortener.module';

@Module({
  imports: [
    ConfigModule.forRoot({isGlobal: true}), 
    MongooseModule.forRoot(process.env.MONGODB_URI ?? ''), 
    UrlShortenerModule
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
