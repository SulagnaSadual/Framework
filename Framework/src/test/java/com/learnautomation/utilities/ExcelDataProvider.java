package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src = new File("/Users/ritsulu/Downloads/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("Unable to read " + e);
		}

	}

	public String getStringData(int sheetIndex, int row, int cell) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}

	public String getStringData(String sheetname, int row, int cell) {
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}

	public double getNumericData(String sheetname, int row, int cell) {
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
	}
}
