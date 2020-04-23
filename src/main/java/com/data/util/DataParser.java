package com.data.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class DataParser {
	//Regresar un object en una lista dado un string en formato JSON
	// El <T> se refiere a algo generico
	public static <T> List<T> parseJSON(String Json, Class<?> clazz){
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
			List<T> returnList = mapper.readValue(Json,listType);
			return returnList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
}
