package Utlis;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtlis {
	
	private static Workbook book;
	private static Sheet sheet;
	
	public static void loadExcel(String filepath,String sheetname) throws IOException {
		FileInputStream fis= new FileInputStream(filepath);
		book= new XSSFWorkbook(fis);
		sheet=book.getSheet(sheetname);
		}
	
	public static String getcelldata(int row, int col) {
		Cell cell=sheet.getRow(row).getCell(col);
		if(cell.getCellType()==CellType.STRING) {
			return cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC) {
			return String.valueOf((int) cell.getNumericCellValue());
			
		}
		return "";
		
		
		}
	public static int getrowcount() {
		return sheet.getPhysicalNumberOfRows();
		
	}
	public static void closeexcel() throws IOException {
		book.close();
	}
	
	
	
	

}
