package com.adidas.wishlist.adidas.api.response;


public class SuggestionsGroups
{
private Values values;

private String suggestion;

public Values getValues ()
{
return values;
}

public void setValues (Values values)
{
this.values = values;
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
return "ClassPojo [values = "+values+", suggestion = "+suggestion+"]";
}
}
