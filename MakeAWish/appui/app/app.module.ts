import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient,HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { StoreComponent } from './store/store.component';
import { AppRoutingModule } from './app.routing';
import { RestService } from './services/rest.service';
import { RestConstantsService } from './constants/rest-constants.service';
import { PricePipe } from './pipes/price.pipe';
import { ResizePipe } from './pipes/resize.pipe';


@NgModule({
  declarations: [
    AppComponent,
    WishlistComponent,
    StoreComponent,
    PricePipe,
    ResizePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [RestService,RestConstantsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
