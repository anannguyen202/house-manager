import { Injectable } from '@angular/core';
import { ApiProvider } from './api';

@Injectable()
export class RHProvider {

    constructor(
        private api: ApiProvider
    ) { }

    public getAll() {
        return this.api.get('room-history/get-all');
    }

    public checkIn(info) {
        return this.api.post('room-history/check-in', info);
    }

    public getCheckIn(id) {
        return this.api.get('room-history/get-check-in/' + id);
    }

}