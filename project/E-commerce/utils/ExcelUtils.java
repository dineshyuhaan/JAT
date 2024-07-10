package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String value;

	public String excelUtils(String sheetName, int rowIndex, int cellIndex) throws IOException {
	
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\cibhi\\eclipse-workspace\\Ecommerce\\Data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowIndex);
			XSSFCell cell = row.getCell(cellIndex);
			CellType cellType = cell.getCellType();

			if (cellType.equals(CellType.STRING)) {
				value = cell.getStringCellValue();
			} else if (cellType.equals(CellType.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				int numeric = (int) numericCellValue;
				cell.getStringCellValue();
				value = String.valueOf(numeric);
			}
			workbook.close();
			return value;
		}
	}