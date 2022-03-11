package com.ty.stores.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	
	private String store_Id;
	private String post_Code;
	private String city;
	private String address;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date opened_Date;
	
	

}
//Store Id,Post Code,City,Address,Opened Date