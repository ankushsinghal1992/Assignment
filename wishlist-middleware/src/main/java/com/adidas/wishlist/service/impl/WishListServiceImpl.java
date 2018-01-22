package com.adidas.wishlist.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adidas.wishlist.adidas.api.response.Products;
import com.adidas.wishlist.adidas.api.response.SearchItemsApiResponse;
import com.adidas.wishlist.dao.WishListDao;
import com.adidas.wishlist.response.dto.AddWishListResponse;
import com.adidas.wishlist.service.WishListService;

@Service("WishListService")
public class WishListServiceImpl implements WishListService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WishListDao wishListDao;

	@Override
	public SearchItemsApiResponse searchItems(String queryObject) {
		// TODO Auto-generated method stub
	
		try{
		return restTemplate.getForObject("https://www.adidas.co.uk/api/suggestions/"+queryObject, SearchItemsApiResponse.class);
		}
		catch(Exception e){
			return null;	
		}
	
	}

	@Override
	public int addToWishList(Products product) {
		// TODO Auto-generated method stub
		return wishListDao.saveItemToWishList(product);
		
	}

	@Override
	public List<Map<String, Object>> getWishList() {
		// TODO Auto-generated method stub
		return wishListDao.getWishList();
	}

	@Override
	public int removeFromWishList(Products product) {
		// TODO Auto-generated method stub
		return wishListDao.deleteFromWishList(product);
	}

	@Override
	public int removeAll() {
		// TODO Auto-generated method stub
		return wishListDao.removeAll();
		
	}

}
