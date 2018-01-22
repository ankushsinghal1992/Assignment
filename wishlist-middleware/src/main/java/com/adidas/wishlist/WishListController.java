package com.adidas.wishlist;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.wishlist.adidas.api.response.Products;
import com.adidas.wishlist.adidas.api.response.SearchItemsApiResponse;
import com.adidas.wishlist.base.response.WishlistResponse;
import com.adidas.wishlist.helper.WishListHelper;
import com.adidas.wishlist.service.WishListService;

/**
 * Handles requests for the application home page.
 */
@RestController
public class WishListController {

	private static final Logger logger = LoggerFactory.getLogger(WishListController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	WishListService wishListService;
	@RequestMapping(value = "/search/{searchQuery}", method = RequestMethod.GET)
	public WishlistResponse<SearchItemsApiResponse> search(HttpSession session,@PathVariable String searchQuery) {
		logger.info("Search Api called");
		SearchItemsApiResponse searchItemsApiResponse= wishListService.searchItems(searchQuery);
		WishlistResponse<SearchItemsApiResponse> wishlistResponse = new WishlistResponse<SearchItemsApiResponse>();
		if(searchItemsApiResponse!=null){
			session.setAttribute("products", searchItemsApiResponse);
			int i=0;
			for(Products products:searchItemsApiResponse.getProducts()){
				products.setIndex(i);
				i++;
			}
			wishlistResponse.setStatus(true);
			wishlistResponse.setResponse(searchItemsApiResponse);
			if(searchItemsApiResponse.getProducts().size()>0){
				wishlistResponse.setResponseStatus(true);
			}
			else{
				wishlistResponse.setResponseStatus(false);
			}
		}
		else{
			wishlistResponse.setStatus(true);
			wishlistResponse.setResponseStatus(false);

		}
		return wishlistResponse;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public WishlistResponse<String> wishlistAdd(@RequestBody Products product){
		int status = wishListService.addToWishList(product);
		WishlistResponse<String> response = new WishlistResponse<String>();
		if(status==1){
			response.setStatus(true);
			response.setResponseStatus(true);

		}
		else{
			response.setStatus(true);
			response.setResponseStatus(false);
		}
		return response;

	}

	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public WishlistResponse<List<Products>> wishlistGet(){
		WishlistResponse<List<Products>> response = new WishlistResponse<List<Products>>();
		List<Map<String, Object>> products= wishListService.getWishList();
		if(products!=null && products.size() > 0){
			List<Products> productList = WishListHelper.mapProductData(products);
			response.setStatus(true);
			response.setResponse(productList);
			response.setResponseStatus(true);
		}
		else{

			response.setStatus(true);
			response.setResponseStatus(false);		}
		return response;

	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public WishlistResponse<String> wishlistRemove(@RequestBody Products product){
		int status =wishListService.removeFromWishList(product);
		WishlistResponse<String> response = new WishlistResponse<String>();
		if(status==1){
			response.setStatus(true);
			response.setResponseStatus(true);
		}
		else{

			response.setStatus(true);
			response.setResponseStatus(false);		}
		return response;

	}

	@RequestMapping(value="/removeAll", method=RequestMethod.GET)
	public WishlistResponse<String> wishlistRemoveAll(){
		int status =wishListService.removeAll();;
		WishlistResponse<String> response = new WishlistResponse<String>();
		if(status==0){
			response.setStatus(true);
			response.setResponseStatus(true);
		}
		else{
			response.setStatus(true);
			response.setResponseStatus(false);		
		}
		return response;

	}



}
