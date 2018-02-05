package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReder {
	
	
	String path;
	XSSFWorkbook workbook;
	XSSFSheet worksheet;
	HashMap<String,String> column = new HashMap<>();
	//consturtor
	public XLReder(String path, String sheet) throws Exception{
		this.path=path;
		FileInputStream fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		worksheet = workbook.getSheet(sheet);
		intilizeColumnMap();
	}
	//object creation
	public String readdata(int rownumber, int coloumnuber){
		String returnvalue=null;
		try {
			XSSFRow row1 = worksheet.getRow(rownumber-1);
			XSSFCell cellA1 = row1.getCell((short) coloumnuber);
			returnvalue = cellA1.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return returnvalue;
	}
	public String readdata(int rownumber, String columnName){
		String returnvalue=null;
		try {

			XSSFRow row1 = worksheet.getRow(rownumber-1);
			int colno =Integer.valueOf( column.get(columnName));
			XSSFCell cellA1 = row1.getCell((short) colno);
			returnvalue = cellA1.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return returnvalue;
	}

	public void setData(int rownumber,int colno,String value){
		try {

			XSSFRow row1 = worksheet.getRow(rownumber-1);
			
			XSSFCell cellA1 = row1.createCell(colno);
			cellA1.setCellValue(value);
			workbook.write(new FileOutputStream(new File(this.path)));
			

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void closeWorkBook() throws IOException{
		
		workbook.close();
	}
	
	
	public void intilizeColumnMap(){
		try{
			XSSFRow row1 = worksheet.getRow(0);
			int columnCont = row1.getLastCellNum();
			for(int i=0;i<=columnCont;i++)
			{
				XSSFCell cell = row1.getCell((short) i);
				column.put(cell.getStringCellValue(), String.valueOf(i));
			}
			
		}catch(Exception e){}
	}


}
