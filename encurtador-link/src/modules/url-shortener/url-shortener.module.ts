import { Module } from '@nestjs/common';
import { UrlShortenerService } from './url-shortener.service';
import { UrlShortenerController } from './url-shortener.controller';
import { MongooseModule } from '@nestjs/mongoose';
import { Link, LinkSchema } from './entities/link_entity';

@Module({
  controllers: [UrlShortenerController],
  providers: [UrlShortenerService],
  imports: [
    MongooseModule.forFeature([{ name: Link.name, schema: LinkSchema }])
  ],
})
export class UrlShortenerModule {}
