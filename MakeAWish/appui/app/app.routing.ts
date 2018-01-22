import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

//import { PopulatedWishlistRouteGuard } from "./route-gaurds/populated-wishlist.route-gaurd";
import { WishlistComponent } from "./wishlist/wishlist.component";
import { StoreComponent } from "./store/store.component";

@NgModule({
    exports: [RouterModule],
    imports: [
        RouterModule.forRoot([
             {
                component: WishlistComponent,
                path: "MakeAWish/checkout"
            }, 
            {
                component: StoreComponent,
                path: "**"
            }])
    ]
})
export class AppRoutingModule { }
