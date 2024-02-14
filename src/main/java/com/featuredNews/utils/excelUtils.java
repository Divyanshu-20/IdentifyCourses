package com.featuredNews.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelUtils {
	
	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFWorkbook workBook;
	public static XSSFSheet workSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;   
	
	//To count number of rows
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fileInput=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fileInput);
		workSheet=workBook.getSheet(xlsheet);
		int rowcount=workSheet.getLastRowNum(); //count last row number and store it in rowcount
		workBook.close();
		fileInput.close();
		return rowcount;		
	}
	
    //To count number of columns
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fileInput);
		workSheet=workBook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);     
		int cellcount=row.getLastCellNum(); //count last cell number and store it in cellcount
		workBook.close();
		fileInput.close();
		return cellcount;
	}
	
	//Reading data from the cell
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fileInput);
		workSheet=workBook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);
		cell=row.getCell(colnum);
	
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter(); //creating an object of DateFormatter
            data = formatter.formatCellValue(cell);
            return data;
		}
		catch (Exception e) 
		{
			data="";
		}
		
		workBook.close();
		fileInput.close();
		return data;
	}
		
    //Writing data into the cell
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fileInput);
		workSheet=workBook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);
		if(row==null)
		{
			row=workSheet.createRow(rownum);
					
		}
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fileOutput=new FileOutputStream(xlfile);
		workBook.write(fileOutput);		
		workBook.close();
		fileInput.close();
		fileOutput.close();				
	}
	
	//To Apply Green Color On Particular Cell
	public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fileInput);
		workSheet=workBook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workBook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); // Filling red color to the cell
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		fileOutput=new FileOutputStream(xlfile);
		workBook.write(fileOutput);
		workBook.close();
		fileInput.close();
		fileOutput.close();
	}
	
	//To Apply Red Color On Particular Cell
	public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fileInput);
		workSheet=workBook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workBook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex()); // Filling red color to the cell
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		fileOutput=new FileOutputStream(xlfile);
		workBook.write(fileOutput);
		workBook.close();
		fileInput.close();
		fileOutput.close();
	}
}

