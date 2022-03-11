package com.ty.stores.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(DetailsNotFoundException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessages storeDetailsNotFound(DetailsNotFoundException exception, WebRequest request) {
		return new ErrorMessages(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), exception.getMessage(),
				request.getDescription(false));
	}

}
