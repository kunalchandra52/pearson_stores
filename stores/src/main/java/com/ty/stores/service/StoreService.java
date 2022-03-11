package com.ty.stores.service;

import java.util.List;

import com.ty.stores.model.Store;

public interface StoreService {

	Store fetchByStoreId(String store_Id);

	List<Store> fetchAllStores(String condition);

}
