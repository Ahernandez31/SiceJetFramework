package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExcelReader {
	static Workbook wBook = null;
	static int LastRow;
	static int LastColumn;
	
	public static String getDataInJsonFormat(Sheet sheet) {
		
		JSONArray array = new JSONArray();
		Row row = sheet.getRow(0);
		String [] headers = getHeaders(sheet);
		LastRow=sheet.getLastRowNum();
		
		
		// Empieza en 1 porque los headers son la posicion 0
		for (int i = 1; i <= LastRow; i++) {
			JSONObject object = new JSONObject();
			row= sheet.getRow(i);
			
			if(row!=null) {
				for (int j = 0; j < LastColumn; j++) {
					Cell cell = row.getCell(j);
					//System.out.println("J = "+j+"i - "+i+ " VALUE - "+cell);
					CellType cellType = cell.getCellType();
					
					switch (cellType) {
					case STRING:
						object.put(headers[j], cell.getStringCellValue());
						break;
					case NUMERIC:
						object.put(headers[j], cell.getNumericCellValue());
						break;					
					case BOOLEAN:
						object.put(headers[j], cell.getBooleanCellValue());
						break;
					case ERROR:
						object.put(headers[j], cell.getErrorCellValue());
						break;
					case _NONE:
						//object.put(headers[j], cell.getDateCellValue());
						break;
					default:
						break;
					}
				}
			}
			
		}
		
		return null;
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
	
	
}
