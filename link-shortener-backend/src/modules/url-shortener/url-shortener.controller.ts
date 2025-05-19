import { Controller, Get, Post, Body, Patch, Param, Delete, Res, HttpStatus } from '@nestjs/common';
import { UrlShortenerService } from './url-shortener.service';
import { BaseResult } from 'src/core/base_result';
import { SaveLinkDto } from 'src/modules/url-shortener/dto/create_link_dto';
import { Response } from 'express';

@Controller('url-shortener')
export class UrlShortenerController {
  constructor(private readonly urlShortenerService: UrlShortenerService) {}

  @Post()
  async createLink(@Body() link: SaveLinkDto): Promise<BaseResult<any>> {
      const result = await this.urlShortenerService.createLink(link);
      if (result.isSuccess) {
          return BaseResult.success(result.message, result.data);
      } else {
          return BaseResult.error(result.message, result.codeError);
      }
  }

  @Get()
  async getAllLinks() : Promise<BaseResult<any>> {
    const result =  await this.urlShortenerService.getAllLinks();
    if (result.isSuccess) {
      return BaseResult.success(result.message, result.data);
    } else {
      return BaseResult.error(result.message, result.codeError);
    }
  }

  @Get(':name/:nanoId')
  async accessLink(
    @Param('name') name: string,
    @Param('nanoId') nanoId: string,
    @Res() res: Response,
  ): Promise<void> {
    const result = await this.urlShortenerService.accessOriginalLink(nanoId);

    if (result.isSuccess) {
      return res.redirect(result.data!!.originalLink);
    } else {
      res.status(404).json(BaseResult.error(result.message, result.codeError));
    }
  }

  @Delete(':id')
  async deleteLinkById(@Param('id') id: string): Promise<BaseResult<any>> {
    const result = await this.urlShortenerService.deleteLinkById(id);
    if (result.isSuccess) {
        return BaseResult.success(result.message, result.data);
    } else {
        return BaseResult.error(result.message, result.codeError);
    }
  }
}
