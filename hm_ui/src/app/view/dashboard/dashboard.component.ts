import { Component, OnInit } from '@angular/core';
import { CountUpTimer } from 'countup-timer-js';
import * as moment from 'moment';
import { RoomProvider } from 'src/app/provider/room';
import { RHProvider } from 'src/app/provider/room-history.';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

    rooms: any;

    constructor(
        private roomProvider: RoomProvider,
        private rh: RHProvider
    ) {
    }

    getRoomTypeFromId(typeId: String, size?: Boolean): String {
        if(!typeId)
            return;

        let tmp;
        let type = size ? typeId.substr(3,2) : typeId.substr(3,2);

        if(size) {
            tmp = (type == 'p1' ? 'Đơn' : 'Đôi');
        }
        else {
            tmp = (type == 'ml' ? 'Phòng lạnh' : 'Phòng quạt');
        }
        
        return tmp; 
    }

    isActivedRoom(status) {
        return status == 'ACT' ? true : false;
    }

    ngOnInit() {
        this.roomProvider.getAll()
            .subscribe((rsp: any) => this.rooms = rsp.result.list);
    }

}