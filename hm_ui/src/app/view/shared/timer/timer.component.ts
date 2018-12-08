import { Component, OnInit, Input } from '@angular/core';
import { CountUpTimer } from 'countup-timer-js';

@Component({
    selector: 'app-timer',
    templateUrl: './timer.component.html',
    styleUrls: ['./timer.component.css']
})
export class TimerComponent implements OnInit {

    @Input() inDate;
    timer;
    countup = '...';

    constructor() { }

    ngOnInit() {
        let inTime = new Date(this.inDate).getTime();
        let milliseconds = new Date().getTime() - inTime;

        let seconds = Math.floor((milliseconds / 1000) % 60);
        let minutes = Math.floor((milliseconds / (1000 * 60)) % 60);
        let hours = Math.floor(((milliseconds / (1000 * 60 * 60)) % 24));

        let lastTime = [hours, minutes, seconds].join(':');

        this.timer = new CountUpTimer(lastTime, (times, parameters) => {
            this.countup = times;
        });
    }

}
