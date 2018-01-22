package com.adidas.wishlist.adidas.api.response;

import java.util.List;

public class SearchItemsApiResponse
{
private SuggestionsGroups[] suggestionsGroups;

private String[] categories;

private Suggestions[] suggestions;

private List<Products> products;

public SuggestionsGroups[] getSuggestionsGroups ()
{
return suggestionsGroups;
}

public void setSuggestionsGroups (SuggestionsGroups[] suggestionsGroups)
{
this.suggestionsGroups = suggestionsGroups;
}

public String[] getCategories ()
{
return categories;
}

public void setCategories (String[] categories)
{
this.categories = categories;
}

public Suggestions[] getSuggestions ()
{
return suggestions;
}

public void setSuggestions (Suggestions[] suggestions)
{
this.suggestions = suggestions;
}

public List<Products> getProducts ()
{
return products;
}

public void setProducts (List<Products> products)
{
this.products = products;
}

@Override
public String toString()
{
return "ClassPojo [suggestionsGroups = "+suggestionsGroups+", categories = "+categories+", suggestions = "+suggestions+", products = "+products+"]";
}
}