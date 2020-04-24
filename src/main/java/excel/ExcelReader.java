package excel;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import com.data.Constants;
import com.data.PropertyLoader;

public class ExcelReader {
	static Workbook wBook = null;
	static int LastRow;
	static int LastColumn;
	
	public static String getDataInJsonFormat(Sheet sheet) {
		
		JSONArray array = new JSONArray();
		Row row = sheet.getRow(0);
		String [] headers = getHeaders(sheet);
		LastRow=sheet.getLastRowNum();
		String value;
		
		// Empieza en 1 porque los headers son la posicion 0
		for (int i = 1; i <= LastRow; i++) {
			JSONObject object = new JSONObject();
			row= sheet.getRow(i);
			
			if(row!=null) {
				
				for (int j = 0; j < LastColumn; j++) {
				
					Cell cell = row.getCell(j);
					DataFormatter formater = new DataFormatter();
					value=formater.formatCellValue(cell);
					object.put(headers[j], value);
					
				}
			}
			array.put(object);
		}
		
		return array.toString(1);
	}
	
	
	private static String[] getHeaders(Sheet sheet) {
		
		if(sheet != null) {
			Row row = sheet.getRow(0);
			LastColumn = row.getLastCellNum();
			String[] headers= new String[LastColumn];
			Header head = sheet.getHeader();
			
			for (int i = 0; i < LastColumn; i++) {
				Cell cell = row.getCell(i);
				headers[i]=cell.getStringCellValue();
			}
			
			return headers;
			
		}else {
			return null;
		}
	
	}
	
	public static String getDefaultData() {
		String json=null;
		
		try {
			wBook = new XSSFWorkbook(PropertyLoader.getProperty(Constants.DATA_FILE));
			
			Sheet sheet = wBook.getSheetAt(0);
			return getDataInJsonFormat(sheet);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return json;
		}
	}
	
}
