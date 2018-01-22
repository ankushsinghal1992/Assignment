import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';
import 'rxjs/add/observable/throw';
import { retry } from 'rxjs/operators/retry';
import { concat } from 'rxjs/observable/concat';
import { ErrorResponse } from '../models/error-response';
import { RestConstantsService } from '../constants/rest-constants.service';


@Injectable()
export class RestService {

    private queryparams: string = "?";
    constructor(private _http: HttpClient,
        private restConstService: RestConstantsService) { }

    //Rest Post Method
    post(url: string, param?: {}): Observable<any> {
       
        let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        let options = { headers: headers };

        console.log('Options: ' + JSON.stringify(options));
        return this._http
            .post(url, param, options)
            .pipe(
            tap(data => {
                console.log(data);
            }),
            catchError(this.responsefailureCallBack)
            );

    }

    //Rest Get Method
    get(url: string, params?: Map<string, any>): Observable<any> {
        if (params == null || params == undefined) {
            params = new Map<string, any>();
        }
        params.set('isAjaxJson', 'true');


        console.log(url, params);
        return this._http
            .get<any>(url, { withCredentials: true, params: this.setParam(params) })
            .pipe(
            tap(data => {
                console.log(data);
            }),
            catchError(this.responsefailureCallBack)
            )




    }

    setCorrectProtocol(url): string {
        let urltoRepalc: string;
        let hosturl: string;

        if (window.location.protocol && window.location.protocol.indexOf("https") != -1 && url.indexOf("https") == -1) {
            url = url.replace("http://", "https://");
            url = url.replace(":8080/", ":8443/");
            url = url.replace(":80/", ":443/");
        } else if (window.location.protocol && window.location.protocol.indexOf("https") == -1 && url.indexOf("https") == -1) {
            url = url.replace("https://", "http://");
            url = url.replace(":8443/", ":8080/");
            url = url.replace(":443/", ":80/");
        }



        return url;
    }

    responsefailureCallBack(err: HttpErrorResponse) {

        let responseObject: ErrorResponse = new ErrorResponse();
        switch (err.status) {

            case 400: {
                responseObject.statusCode = err.status;
                responseObject.errorString = "Your Request is inValid";
                break;
            }

            case 401: {
                responseObject.statusCode = err.status;
                responseObject.errorString = "Your are unauthorized for the request you have made";
                break;
            }
            case 403: {
                responseObject.statusCode = err.status;
                responseObject.errorString = "Your are forbidden to access the server";
                break;
            }
            case 404: {
                console.log("The resource you are trying to access is not found on the server.");
                responseObject.statusCode = err.status;
                responseObject.errorString = "The resource you are trying to access is not found on the server.";

                break;
            }
            case 408: {
                responseObject.statusCode = err.status;
                responseObject.errorString = "your Request has timed out";
                break;
            }
            default: {
                responseObject.statusCode = err.status;
                responseObject.errorString = "Some Unknown error has occured , Please try again later."
            }

        }
        alert(responseObject.errorString);
        return Observable.throw(responseObject);


    }

    setParam(map: Map<string, any>): HttpParams {
        let param = new HttpParams();

        if (map != null && map.size >= 1) {
            map.forEach((value: string, key: string) => {

                param = param.append(key, value);
                console.log(key + value);
            });

        }
        console.log(param);
        return param;
    }



    setHeaders(map: Map<string, any>): HttpHeaders {
        console.log('MAP IS' + map);
        let headers = new HttpHeaders();
        if (map != null && map.size >= 1) {
            map.forEach((key: string, value: string) => {
                headers.append(key, value);
            });
            return headers;
        } else {
            return headers;
        }
    }


}