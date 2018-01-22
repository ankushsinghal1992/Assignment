import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'resize'
})
export class ResizePipe implements PipeTransform {

  transform(value: string, args?: any): any {
    let imagePath = "https://www.adidas.com/static/on/demandware.static/Sites-adidas-US-Site/-/default/dw721d387e/images/favicons/favicon.png";
    if(value){
      imagePath = value.substr(0,value.lastIndexOf('?'));
    }
    return imagePath;
  }

}
