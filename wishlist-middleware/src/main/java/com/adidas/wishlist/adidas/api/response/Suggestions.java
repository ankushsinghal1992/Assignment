package com.adidas.wishlist.adidas.api.response;


public class Suggestions
{
private String hits;

private String count;

private String suggestion;

public String getHits ()
{
return hits;
}

public void setHits (String hits)
{
this.hits = hits;
}

public String getCount ()
{
return count;
}

public void setCount (String count)
{
this.count = count;
}

public String getSuggestion ()
{
return suggestion;
}

public void setSuggestion (String suggestion)
{
this.suggestion = suggestion;
}

@Override
public String toString()
{
return "ClassPojo [hits = "+hits+", count = "+count+", suggestion = "+suggestion+"]";
}
}
