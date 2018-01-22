package com.adidas.wishlist.service;

import java.util.List;
import java.util.Map;

import com.adidas.wishlist.adidas.api.response.Products;
import com.adidas.wishlist.adidas.api.response.SearchItemsApiResponse;
import com.adidas.wishlist.response.dto.AddWishListResponse;

public interface WishListService {

	public SearchItemsApiResponse searchItems(String queryObject);
	public int addToWishList(Products product);
	public List<Map<String,Object>> getWishList();
	public int removeFromWishList(Products product);
	public int removeAll();
}
