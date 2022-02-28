package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException{
		
		projectPath = System.getProperty("user.dir");
		Object[][] excelPath = getExcelData(projectPath+ "/excel/agentlogin.xlsx", "AgentLogin");
		return excelPath;
	}
	
	
	public String[][] getExcelData(String fileName, String sheetName) throws IOException{
		String[][]data = null;

		// Excel
		FileInputStream fs = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(rowCount +"-------"+ colCount);

		data = new String[rowCount-1][colCount];

		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++){

				XSSFCell cellData = sheet.getRow(row).getCell(col);
				data[row-1][col] = cellData.getRawValue();
			}
		}return data;
	}

}
