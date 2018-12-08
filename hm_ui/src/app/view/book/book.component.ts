import { Component, OnInit } from '@angular/core';
import { Location, formatDate, DatePipe } from '@angular/common';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RHProvider } from 'src/app/provider/room-history.';
declare var $: any

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html',
    styleUrls: ['./book.component.css'],
    providers: [DatePipe]
})
export class BookComponent implements OnInit {

    bookForm: FormGroup;
    isHourMax = false;
    isHourMin = false;
    isMinuteMax = false;
    isMinuteMin = false;

    roomId;
    typeId;
    roomPerson;
    description;

    constructor(
        private location: Location,
        private fb: FormBuilder,
        private ar: ActivatedRoute,
        private rh: RHProvider,
        private datePipe: DatePipe
    ) {
        const d = new Date();
        const hour = formatDate(d, 'hh', 'en');
        const aa = formatDate(d, 'aa', 'en');

        this.bookForm = this.fb.group({
            roomSize: ['p1'],
            type: ['ml'],
            inHours: [hour],
            inMinutes: [d.getMinutes()],
            timeType: [aa],
            roomPerson: ['1'],
            description: []
        });
        
        this.roomId = this.ar.snapshot.paramMap.get('id');
    }

    ngOnInit() {
    }

    canSelectRoomSize(roomId: String) {
        return roomId == '1' ? false : true;
    }

    ngAfterViewInit() {
        $("#inMinutes").on("keypress", function (e) {
            const currentValue = String.fromCharCode(e.which);
            const finalValue = $(this).val() + currentValue;
            if (+finalValue > 59) {
                e.preventDefault();
            }
        });
        $("#inHours").on("keypress", function (e) {
            const currentValue = String.fromCharCode(e.which);
            const finalValue = $(this).val() + currentValue;
            if (+finalValue > 12) {
                e.preventDefault();
            }
        });
        $("#inHours").on('keyup mouseup', function (e) {
            const currentValue = $(this).val();
            if(this.isHourMin) {
                $("#inHours").val('12');
                this.isHourMin = false;
                return;
            }
            if(this.isHourMax) {
                $("#inHours").val('1');
                this.isHourMax = false;
                return;
            }
            if(currentValue == 1) {
                this.isHourMin = true;
                return;
            }
            if(currentValue == 12) {
                this.isHourMax = true;
                return;
            }
        });
        $("#inMinutes").on('keyup mouseup', function (e) {
            const currentValue = $(this).val();
            if(this.isMinuteMin) {
                $("#inMinutes").val('59');
                this.isMinuteMin = false;
                return;
            }
            if(this.isMinuteMax) {
                $("#inMinutes").val('0');
                this.isMinuteMax = false;
                return;
            }
            if(currentValue == 0) {
                this.isMinuteMin = true;
                return;
            }
            if(currentValue == 59) {
                this.isMinuteMax = true;
                return;
            }
        });
    }

    getDateWithHour(hour, minute, timeType): String {
        const today = formatDate(new Date(), 'yyyy-MM-dd', 'en');
        const hourSelected = [hour,minute,'00'].join(':');
        const tmp = [today, hourSelected, timeType].join(' ');
        return this.datePipe.transform(tmp, "yyyy-MM-dd HH:mm:ss");
    }

    onSubmit() {
        const bookForm = this.bookForm.value;

        const inHours = bookForm.inHours;
        const inMinutes = bookForm.inMinutes;
        const timeType = bookForm.timeType;

        const type = bookForm.type;
        const roomSize = bookForm.roomSize;

        //convert
        this.typeId = [roomSize,type].join('-');

        const info = {
            "roomId": this.roomId,
            "typeId": this.typeId,
            "inDate": this.getDateWithHour(inHours,inMinutes,timeType),
            "description": bookForm.description
        }

        this.rh.checkIn(info)
            .subscribe((rsp: any) => console.log(rsp));
    }

    onBack() {
        this.location.back();
    }

}
