import { Component, OnInit } from '@angular/core';
import { RestService } from '../services/rest.service';
import { SearchData } from '../models/search-data';
import { RestConstantsService } from '../constants/rest-constants.service';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {
  searchData: SearchData = new SearchData();
  rendered: boolean = false;
  removedWishlists = [];
  status: boolean = false;
  loading: boolean = false;
  listEmpty : boolean = false;
  constructor(private restService: RestService,
    private restConstService: RestConstantsService) { }


  ngOnInit() {
    let params = new Map<string, any>();
    this.restService.get(
      this.restConstService.restConst.ORIGIN_URL + this.restConstService.restConst.GET, params).subscribe(
      data => {
        if (data && data.status && data.responseStatus) {
          this.searchData.products = data.response;
          this.status = true;
        }
        else {
          this.status = false;
        }
        this.rendered = true;

      });
  }

  removeItemFromWishlist(index) {
    this.loading = true;
    if (this.searchData && this.searchData.products && this.searchData.products.length > 0) {
      this.restService.post(
        this.restConstService.restConst.ORIGIN_URL + this.restConstService.restConst.REMOVE, JSON.stringify(this.searchData.products[index])).subscribe(
        data => {
          if (data && data.status && data.responseStatus) {
            let params = new Map<string, any>();
            this.restService.get(
              this.restConstService.restConst.ORIGIN_URL + this.restConstService.restConst.GET, params).subscribe(
              data => {
                if (data && data.status) {
                  if(data.responseStatus){
                    this.searchData.products = data.response;
                    this.status = true;
                  }
                  else{
                    this.listEmpty = true;
                  }
                  
                }
                else {
                  this.status = false;
                }
                this.rendered = true;

              });
          }

        });
    }
    this.loading = false;
  }

}
