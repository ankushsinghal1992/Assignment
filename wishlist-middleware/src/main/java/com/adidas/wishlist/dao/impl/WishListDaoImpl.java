package com.adidas.wishlist.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adidas.wishlist.adidas.api.response.Products;
import com.adidas.wishlist.dao.WishListDao;

@Repository("WishListDao")
@Configuration
public class WishListDaoImpl implements WishListDao {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
			.addScript("db/drop-table.sql")
			.addScript("db/create-table.sql")
			.build();
		return db;
    } 
	


	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	@Override
	@Transactional
	public int saveItemToWishList(Products product) {
		// TODO Auto-generated method stub
//		String sql="insert into wishlist values('hello','hello','hello','hello','hello','hello','hello','hello','hello')";
		
		int status;
		try{
		status= jdbcTemplate().update("insert into wishlist values(?,?,?,?,?,?,?,?,?)",new Object[]{product.getSubTitle(),product.getIsPreorder(),product.getReviews()
				,product.getSeparatedStandartPrice(),product.getSeparatedSalePrice(),product.getImage(),product.getSuggestion()
				,product.getRating(),product.getUrl()});
		}
		catch(Exception e){
		status=0;
		
		}
		return status;
		
	}

	@Override
	public List<Map<String,Object>> getWishList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM wishlist";
		List<Map<String, Object>> wishList = jdbcTemplate().queryForList(sql);
		return wishList;
		}



	@Override
	public int deleteFromWishList(Products product) {
		// TODO Auto-generated method stub
		int status;
		try{
		status= jdbcTemplate().update("delete from wishlist where suggestion = ? and url = ?",new Object[]{product.getSuggestion(),
				product.getUrl()});
		}catch(Exception e){
			status=1;
		}
		return status;
	}



	@Override
	public int removeAll() {
		// TODO Auto-generated method stub
		int status;
		try{
			
			status= jdbcTemplate().update("truncate table wishlist");
		}
		catch(Exception e){
			status = 0;
		}
		return status;
	}

}
