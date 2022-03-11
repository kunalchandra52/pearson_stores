package com.ty.stores.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessages {
	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;

}
