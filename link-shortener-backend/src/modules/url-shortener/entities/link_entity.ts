import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { Document } from 'mongoose';

export type LinkDocument = Link & Document;

@Schema()
export class Link {
    
    @Prop({ required: true,unique: true })
    id: string;

    @Prop({ required: true })
    originalLink: string;

    @Prop({ required: true, unique: true })
    shortLink: string;

    @Prop({ default: 0 })
    access: number;
}

export const LinkSchema = SchemaFactory.createForClass(Link);
