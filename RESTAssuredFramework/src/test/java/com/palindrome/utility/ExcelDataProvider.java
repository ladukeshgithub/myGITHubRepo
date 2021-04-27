package com.palindrome.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		File src = new File("./TestData/testdata.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel"+e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex, int rowNum, int columnNum){
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(columnNum).getStringCellValue();
	}

}
