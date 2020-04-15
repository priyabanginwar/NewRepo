package com.genricLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
public String fetchDatafromProperty(String key) throws IOException 	
{
	FileInputStream file=new FileInputStream("./src/main/resources/testCaseData/CommonData.properties");
	Properties pobj=new Properties();
	pobj.load(file);
	String value=pobj.getProperty(key);
	return value;
}

public String fetchDatafromExcel(String SheetName,int RowNo,int ColNo) throws IOException
{
	FileInputStream file=new FileInputStream("./testCaseData/TestData1.xlsx");
	Workbook book=WorkbookFactory.create(file);
	Sheet sh=book.getSheet(SheetName);
	Row ro=sh.getRow(RowNo);
	Cell col=ro.getCell(ColNo);
	String value=col.getStringCellValue();
	return value;
}

public void setDatainExcel(String SheetName,int RowNo,int ColNo,String value) throws IOException
{
	FileInputStream file=new FileInputStream("./testCaseData/TestData1.xlsx");
	Workbook book=WorkbookFactory.create(file);
	Sheet sh=book.getSheet(SheetName);
	Row ro=sh.createRow(RowNo);
	Cell col=ro.createCell(ColNo);
	col.setCellValue(value);
	FileOutputStream out=new FileOutputStream("./testCaseData/TestData1.xlsx");
	book.write(out);
}	
}
