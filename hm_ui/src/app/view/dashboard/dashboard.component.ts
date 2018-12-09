import { Component, OnInit } from '@angular/core';
import { RoomProvider } from 'src/app/provider/room';
import { RHProvider } from 'src/app/provider/room-history.';
import { Room, Text } from 'src/app/utilities/const';

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

    getRoomTypeFromId(typeId: String, isSize?: Boolean): String {
        if(!typeId)
            return;

        let tmp;
        let size = typeId.substr(0,2);
        let type = typeId.substr(3,2);

        if(isSize) {
            tmp = (size == Room.SINGLE ? Text.SINGLE : Text.COUPLE);
        }
        else {
            tmp = (type == Room.AIR ? Text.AIR : Text.FUN);
        }
        
        return tmp; 
    }

    isActivedRoom(status) {
        return status == Room.STATUS_ACTIVE;
    }

    ngOnInit() {
        this.roomProvider.getAll()
            .subscribe((rsp: any) => this.rooms = rsp.result.list);
    }

}