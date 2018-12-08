import { Injectable } from '@angular/core';
import { ApiProvider } from './api';

@Injectable()
export class RoomProvider {

    constructor(
        private api: ApiProvider
    ) { }

    public getAll() {
        return this.api.get('room/get-av');
    }
}