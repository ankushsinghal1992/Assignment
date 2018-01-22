package com.adidas.wishlist.adidas.api.response;


public class Products
{
private String subTitle;

private String isPreorder;

private String reviews;

private String separatedStandartPrice;

private String separatedSalePrice;

private String image;

private String suggestion;

private String rating;

private String url;

private int index;

public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}

public String getSubTitle ()
{
return subTitle;
}

public void setSubTitle (String subTitle)
{
this.subTitle = subTitle;
}

public String getIsPreorder ()
{
return isPreorder;
}

public void setIsPreorder (String isPreorder)
{
this.isPreorder = isPreorder;
}

public String getReviews ()
{
return reviews;
}

public void setReviews (String reviews)
{
this.reviews = reviews;
}

public String getSeparatedStandartPrice ()
{
return separatedStandartPrice;
}

public void setSeparatedStandartPrice (String separatedStandartPrice)
{
this.separatedStandartPrice = separatedStandartPrice;
}

public String getSeparatedSalePrice ()
{
return separatedSalePrice;
}

public void setSeparatedSalePrice (String separatedSalePrice)
{
this.separatedSalePrice = separatedSalePrice;
}

public String getImage ()
{
return image;
}

public void setImage (String image)
{
this.image = image;
}

public String getSuggestion ()
{
return suggestion;
}

public void setSuggestion (String suggestion)
{
this.suggestion = suggestion;
}

public String getRating ()
{
return rating;
}

public void setRating (String rating)
{
this.rating = rating;
}

public String getUrl ()
{
return url;
}

public void setUrl (String url)
{
this.url = url;
}

@Override
public String toString()
{
return "ClassPojo [subTitle = "+subTitle+", isPreorder = "+isPreorder+", reviews = "+reviews+", separatedStandartPrice = "+separatedStandartPrice+", separatedSalePrice = "+separatedSalePrice+", image = "+image+", suggestion = "+suggestion+", rating = "+rating+", url = "+url+"]";
}
}
