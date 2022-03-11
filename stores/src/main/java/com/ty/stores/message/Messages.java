package com.ty.stores.message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Messages {
	
		private boolean error;
		private String message;
		private Object Data;

}
