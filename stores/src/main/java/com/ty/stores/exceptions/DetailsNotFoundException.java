package com.ty.stores.exceptions;
@SuppressWarnings("serial")
public class DetailsNotFoundException extends RuntimeException {
	public DetailsNotFoundException(String message) {
		super(message);
	}
}
