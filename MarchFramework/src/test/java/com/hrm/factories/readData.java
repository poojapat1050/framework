package com.hrm.factories;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readData {
public static String getProperty(String input)
{
	Properties pro = new Properties();
	try {
		pro.load(new FileInputStream(new File(
				System.getProperty("user.dir")+"\\configfiles\\testdata.properties")));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	
}
	return (String) pro.get(input);
}

public static String getExceldata(String sheetname, int row, int coll)
{
	String input="";

	File src = new File(
			System.getProperty("user.dir")+"\\testdata\\testdataexcel.xlsx");
	try {
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetname);
		input=(String)sh.getRow(row).getCell(coll).getStringCellValue();
	}catch(Exception e)
	{
	}
	return input;
	
}

}