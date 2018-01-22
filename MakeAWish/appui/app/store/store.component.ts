import { Component, OnInit } from '@angular/core';
import { RestService } from '../services/rest.service';
import { Renderer } from '@angular/core';
import { ElementRef } from '@angular/core';
import { RestConstantsService } from '../constants/rest-constants.service';
import { SearchData } from '../models/search-data';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  searchData: SearchData;
  rendered: boolean = false;
  addedWishlists = [];
  searchClicked = false;
  searchItem: string;
  loading: boolean = false;
  status: boolean = false;
  showErrorList = [];
  constructor(private restService: RestService,
    private restConstService: RestConstantsService) { }

  ngOnInit() {
   let params = new Map<string, any>();
    this.restService.get(
      this.restConstService.restConst.ORIGIN_URL + this.restConstService.restConst.SEARCH + "/shoes", params).subscribe(
      data => {
        if (data && data.status && data.responseStatus) {
          this.searchData = data.response;
          this.status = true;
        }
        else{
          this.status = false;
        }
        this.rendered = true;

      });
  }

  onSearchIconClick() {
    this.searchClicked = !this.searchClicked;
  }

  search() {
    this.loading = true;
    this.showErrorList = [];
    let params = new Map<string, any>();
    this.restService.get(
      this.restConstService.restConst.ORIGIN_URL + this.restConstService.restConst.SEARCH + "/" + this.searchItem, params).subscribe(
      data => {
        if (data && data.status && data.responseStatus) {
          this.searchData = data.response;
          this.status = true;
          this.addedWishlists = [];
        }
        else{
          this.status = false;
        }
        this.rendered = true;
        this.loading = false;
      });
  }

  addProductToWishlist(index: number, event): void {
    if (this.searchData && this.searchData.products && this.searchData.products.length > 0) {
     this.restService.post(
        this.restConstService.restConst.ORIGIN_URL + this.restConstService.restConst.ADD, JSON.stringify(this.searchData.products[index])).subscribe(
        data => {
          if (data && data.status && data.responseStatus) {
            event.target.textContent = "Added";
            this.addedWishlists.push(index);
          }
          else{
            this.showErrorList.push(index);
          }
        });
    }

  }

  clearWishlist(){
    let params = new Map<string, any>();

    this.restService.get(
      this.restConstService.restConst.ORIGIN_URL + this.restConstService.restConst.REMOVE_ALL , params).subscribe(
      data => {
        if (data && data.status && data.responseStatus) {
          this.status = true;
          this.addedWishlists = [];
        }
        else{
          this.status = false;
        }
        this.rendered = true;
      });
  }


  showHideError(index: number) {
    if (this.showErrorList.indexOf(index) != -1) {
      this.showErrorList.splice(this.showErrorList.indexOf(index), 1);
    }
    else {
      this.showErrorList.push(index);
    }
  }

}
