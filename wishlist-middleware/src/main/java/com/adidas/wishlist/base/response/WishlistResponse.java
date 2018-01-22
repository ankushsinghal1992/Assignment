package com.adidas.wishlist.base.response;

public class WishlistResponse<T> {
private T response;
private boolean status;
private boolean responseStatus;


public T getResponse() {
	return response;
}
public void setResponse(T response) {
	this.response = response;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public boolean isResponseStatus() {
	return responseStatus;
}
public void setResponseStatus(boolean responseStatus) {
	this.responseStatus = responseStatus;
}
}
