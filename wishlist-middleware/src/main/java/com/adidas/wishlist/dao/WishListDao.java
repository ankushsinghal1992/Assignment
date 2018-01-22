package com.adidas.wishlist.dao;

import java.util.List;
import java.util.Map;

import com.adidas.wishlist.adidas.api.response.Products;


public interface WishListDao {

public int saveItemToWishList(Products product);
public List<Map<String,Object>> getWishList();
public int deleteFromWishList(Products product);
public int removeAll();
}
