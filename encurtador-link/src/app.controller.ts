import { Body, Controller, Delete, Get, Post, Param } from '@nestjs/common';
import { AppService } from './app.service';
import { BaseResult } from 'src/core/base_result';
import { SaveLinkDto } from './modules/url-shortener/dto/create_link_dto';

@Controller("app")
export class AppController {
  constructor(private readonly appService: AppService) {}



}
