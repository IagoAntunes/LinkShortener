import { IsString, IsNotEmpty, IsUrl } from 'class-validator';

export class SaveLinkDto {
    @IsString()
    @IsNotEmpty()
    originalLink: string;

    @IsString()
    @IsNotEmpty()
    shortLink: string;
}