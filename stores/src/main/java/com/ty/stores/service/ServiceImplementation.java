package com.ty.stores.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.ty.stores.model.Store;

@Service
public class ServiceImplementation implements StoreService {

	@Override
	public Store fetchByStoreId(String store_Id) {
		try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/stores.csv"))) {
			@SuppressWarnings("resource")
			CSVParser parser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			Iterable<CSVRecord> csvRecord = parser.getRecords();
			for (CSVRecord csvRecordTwo : csvRecord) {
				if (csvRecordTwo.get("Store Id").equals(store_Id)) {
					Store storeDto = new Store();
					storeDto.setStore_Id(csvRecordTwo.get("Store Id"));
					storeDto.setPost_Code(csvRecordTwo.get("Post Code"));
					storeDto.setCity(csvRecordTwo.get("City"));
					storeDto.setAddress(csvRecordTwo.get("Address"));
					System.out.println();
					storeDto.setOpened_Date(new SimpleDateFormat("dd/MM/yyyy").parse(csvRecordTwo.get("opened Date")));
					return storeDto;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return null;
	}

	@Override
	public List<Store> fetchAllStores(String condition) {
		System.out.println("Hi");
		try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/stores.csv"))) {
			System.out.println(reader);
			@SuppressWarnings("resource")
			CSVParser parser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			List<Store> list = new ArrayList<Store>();
			Iterable<CSVRecord> csvRecord = parser.getRecords();

			for (CSVRecord csvRecordTwo : csvRecord) {
				Store storeDto = new Store();
				storeDto.setStore_Id(csvRecordTwo.get("Store Id"));
				storeDto.setPost_Code(csvRecordTwo.get("Post Code"));
				storeDto.setCity(csvRecordTwo.get("City"));
				storeDto.setAddress(csvRecordTwo.get("Address"));
				storeDto.setOpened_Date(new SimpleDateFormat("dd/MM/yyyy").parse(csvRecordTwo.get("opened Date")));
				list.add(storeDto);
			}
			if (condition.equalsIgnoreCase("city")) {
				return list.stream().sorted(Comparator.comparing(Store::getCity))
						.collect(Collectors.toList());
			} else if (condition.equalsIgnoreCase("date")) {
				return list.stream().sorted(Comparator.comparing(Store::getOpened_Date))
						.collect(Collectors.toList());
			}
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return null;
	}

}
