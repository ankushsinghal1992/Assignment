package com.adidas.wishlist.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.adidas.wishlist.adidas.api.response.Products;

public class WishListHelper {

	public static List<Products> mapProductData(List<Map<String, Object>> products) {
		List<Products> productList = new ArrayList<Products>();

		for(Map<String, Object> productMap : products){
			Products product = new Products();

			product.setImage((String) productMap.get("IMAGE"));
			//product.setRating((String) productMap.get("RATING"));
			//product.setReviews((String) productMap.get("REVIEWS"));
			product.setSeparatedSalePrice((String) productMap.get("SEPARATEDSALEPRICE"));
			//product.setSeparatedStandartPrice((String) productMap.get("SEPARATEDSTANDARDPRICE"));
			product.setSubTitle((String) productMap.get("SUBTITLE"));
			product.setSuggestion((String) productMap.get("SUGGESTION"));
			product.setUrl((String) productMap.get("URL"));

			productList.add(product);

		}
		return productList;
	}

}
