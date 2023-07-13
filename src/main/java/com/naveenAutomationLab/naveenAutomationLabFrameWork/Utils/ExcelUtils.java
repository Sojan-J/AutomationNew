package com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fs;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String file, String sheet) throws IOException {
		int rowCount;
		fs=new FileInputStream(file);
		wb=new XSSFWorkbook(fs);
		ws=wb.getSheet(sheet);
		fs.close();
		wb.close();
	return 	rowCount=ws.getPhysicalNumberOfRows();
	}
	public static int getCellCount(String file, String sheet, int rowCount) throws IOException {
		int cellCount;
		fs=new FileInputStream(file);
		wb=new XSSFWorkbook(fs);
		ws=wb.getSheet(sheet);
		row=ws.getRow(rowCount-1);
		cellCount=row.getLastCellNum();
		fs.close();
		wb.close();
		return cellCount;
	}
	public static String getCellValue(String file, String sheet, int rowCount, int cellCount) throws IOException {
		String cellValue=null;
		fs=new FileInputStream(file);
			wb=new XSSFWorkbook(fs);
		ws=wb.getSheet(sheet);
		row=ws.getRow(rowCount);
		cell=row.getCell(cellCount);
		cellValue=cell.getStringCellValue();
		fs.close();
		wb.close();
		return cellValue;
	}

}
