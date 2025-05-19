import { Injectable } from '@nestjs/common';
import { customAlphabet } from 'nanoid';
import { v4 as uuidv4 } from 'uuid';

export class UuidGeneratorService {
    private static readonly alphabet = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    private static readonly size = 8;

    static generateUuidV4(): string {
        return uuidv4()
    }

    static generateShortId(): string {
        const nanoid = customAlphabet(this.alphabet, this.size);
        return nanoid();
    }
}