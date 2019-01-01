
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { config, environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

/**
 * API is a generic REST Api handler. Set your API url first.
 */
@Injectable()
export class ApiProvider {
    public apiUrl = '';
    public imgUrl = '';

    constructor(private http: HttpClient, private rou: Router) {
        console.log(environment.production);
        if (environment.production) {
            let tmp = !config.apiUrl.startsWith(location.origin) ? location.origin : '';
            this.apiUrl = tmp + config.apiUrl;

            tmp = !config.imgUrl.startsWith(location.origin) ? location.origin : '';
            this.imgUrl = tmp + config.imgUrl;
        }
        else {
            this.apiUrl = config.apiUrl;
            this.imgUrl = config.imgUrl;
        }
        console.log(this.apiUrl);
    }

    public getToken(): string {
        if (typeof localStorage !== 'undefined' && localStorage.length > 0)
            return 'Bearer ' + localStorage.getItem('accessToken');
        return '';
    }

    public get(endpoint: string, reqOpts?: any) {
        if (!reqOpts) {
            let h = new HttpHeaders().set('Authorization', this.getToken());
            h = h.append('Content-Type', 'application/json');
            reqOpts = { headers: h };
        }

        return this.http.get(this.apiUrl + endpoint, reqOpts);
    }

    public post(endpoint: string, body: any, reqOpts?: any) {
        if (!reqOpts) {
            let h = new HttpHeaders().set('Authorization', this.getToken());
            // h = h.append('Content-Type', 'application/json');
            reqOpts = { headers: h };
        }

        return this.http.post(this.apiUrl + endpoint, body, reqOpts);
    }

    public put(endpoint: string, body: any, reqOpts?: any) {
        if (!reqOpts) {
            let h = new HttpHeaders().set('Authorization', '');
            h = h.append('Content-Type', 'application/json');
            reqOpts = { headers: h };
        }

        return this.http.put(this.apiUrl + endpoint, body, reqOpts);
    }

}