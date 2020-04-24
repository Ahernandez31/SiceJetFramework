package com.data;

import java.util.HashMap;
import java.util.List;

import com.data.util.DataParser;

import excel.ExcelReader;
import com.vo.*;


public class FlightDescriptionSingleton {
	
	//Llave y valor
	//Tipo de llave y el valor que llevara
	private static HashMap<String, FlightDescription> data = null;
	
	
	//Constructor forzosamente debe de ser privado
	private FlightDescriptionSingleton() {
		//Va a inicializar los datos
		
	}
	
	public static HashMap<String,FlightDescription> getFlightDescriptionSingleton() {
		//Va a regresar los datos y obligatoriamente debe de ser static
		//Como el metodo es static todas las variables deben de ser static
		//Si data es null es porque es la primera vez que se llamara al metodo
		if(data==null) {
			data = new HashMap<String,FlightDescription>();
			
			List<FlightDescription> lista = DataParser.parseJSON(ExcelReader.getDefaultData(), FlightDescription.class);
			for (FlightDescription flightDescription : lista) {
				data.put(flightDescription.getTEST(), flightDescription);
			}
			return data;
		}else {
			return data;
		}
		
		
	}
	
	
}
