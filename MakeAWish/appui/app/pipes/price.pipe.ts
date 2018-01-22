import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'price'
})
export class PricePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    let currencyCode : string = "$";
    let amount : string = "100";
    if(value){
      let jsonObj = JSON.parse(value);
      if(jsonObj && jsonObj.length > 0){
        if(jsonObj[0] != undefined && jsonObj[0].isCurrency){
          currencyCode = jsonObj[0].value;
        }
        else{
          amount =  jsonObj[0].value;
        }
        if(jsonObj[1] != undefined && jsonObj[1].isCurrency){
          currencyCode = jsonObj[1].value;
        }
        else{
          amount =  jsonObj[1].value;
        }
      }
    }
    return currencyCode + " " + amount;
  }

}
