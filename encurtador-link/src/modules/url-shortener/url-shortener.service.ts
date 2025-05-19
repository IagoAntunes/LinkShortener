import { Injectable } from '@nestjs/common';
import { BaseResult } from 'src/core/base_result';
import { SaveLinkDto } from 'src/modules/url-shortener/dto/create_link_dto';
import { UuidGeneratorService } from 'src/services/uuid/uuid_generator_service';
import { Link, LinkDocument } from './entities/link_entity';
import { InjectModel } from '@nestjs/mongoose';
import { Model } from 'mongoose';
import { UrlShortenerErrorCodes } from './utils/url-shortener-erros-code';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class UrlShortenerService {

  constructor(
    @InjectModel(Link.name) private linkModel: Model<LinkDocument>,
    private readonly configService: ConfigService 
  ) {} 

  async deleteLinkById(id: string) : Promise<BaseResult<Link[]>> {
    try {
      const filteredLink = await this.linkModel.findOne({id: id});
      await this.linkModel.deleteOne({id: id});
      if(!filteredLink) {
        return BaseResult.error('Link not found', UrlShortenerErrorCodes.LINK_NOT_FOUND);
      }
      let links = await this.getAllLinks();
      return BaseResult.success('Link deleted successfully', links.data!!);
    } catch (error) {
      return BaseResult.error('Error deleting link', UrlShortenerErrorCodes.ERROR_DELETING_LINK);
    }
  }


  async getAllLinks() : Promise<BaseResult<Link[]>> {
    try {
      const links = await this.linkModel.find();
      return BaseResult.success('Links retrieved successfully', links);
    } catch (error) {
      return BaseResult.error('Error retrieving links', UrlShortenerErrorCodes.ERROR_RETRIEVING_LINKS);
    }
  }

  async accessOriginalLink(nanoId: string) : Promise<BaseResult<Link>>{
    try {
      const link = await this.linkModel.findOne({id: nanoId});
      if(!link) {
        return BaseResult.error('Link not found', UrlShortenerErrorCodes.LINK_NOT_FOUND);
      }
      link.access += 1;
      await link.save();
      return BaseResult.success('Links retrieved successfully', link);
    } catch (error) {
      return BaseResult.error('Error retrieving links', UrlShortenerErrorCodes.LINK_NOT_FOUND);
    }
  }


  async createLink(linkDto: SaveLinkDto): Promise<BaseResult<Link | null>> {
    try {
      let uuid = UuidGeneratorService.generateShortId();
      const baseUrl = this.configService.get<string>('BASE_URL');
      const formattedLink = `${baseUrl}/url-shortener/${linkDto.shortLink}/${uuid}`;
      const createdLink = new this.linkModel({
        id: uuid,
        originalLink: linkDto.originalLink,
        shortLink: formattedLink,
        access: 0,
      });

      const savedLink = await createdLink.save();
      return BaseResult.success('Link saved successfully', savedLink);
    } catch (error) {
      return BaseResult.error('Error saving link', UrlShortenerErrorCodes.ERROR_SAVING_LINK);
    }
  }
}
