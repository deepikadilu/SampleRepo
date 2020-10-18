package excelUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	private static XSSFSheet ExcelWSheet; 
	private static XSSFWorkbook ExcelWBook;
	private  XSSFCell Cell;
	private  XSSFRow Row;
	
//	public static void main(String[] args) throws Exception {
//		String exlPath="C:\\Users\\ADMIN\\eclipse-workspace\\CucumberProjTest\\ExcelData\\ExcelTestData.xlsx";
//		ReadWriteExcel rw= new ReadWriteExcel(exlPath);
//		String data =rw.getCellData();
//		System.out.println(data);
//		rw.setCellData("TestCase Pass");
//		//System.out.println("TestCase Pass");
//	
//	}
	FileInputStream ExcelFile;
	FileOutputStream fos;
	
	public ReadWriteExcel(String exlpath) {
	
		try {
			ExcelFile = new FileInputStream(exlpath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	
	public String getCellData() throws Exception{
		int RowNum=0;
		int ColNum=0;
		long num;
		//XSSFCell Cell;
		String CellData = null;
		try{
			//RowNum = ExcelWSheet.getPhysicalNumberOfRows();
			
			Cell = ExcelWSheet.getRow(1).getCell(0);
			num= (long) Cell.getNumericCellValue();
			//CellData = Cell.getStringCellValue();
			//System.out.println(num);
			CellData=String.valueOf(num);
			//return CellData;
		}catch (Exception e){

			e.printStackTrace();
			return "";

		}
	
		finally {
		    if (ExcelFile!=null) {
		    	ExcelFile.close();
		    }
		}
		return CellData;
	}
	
	public void setCellData(String writeData) throws Exception{
		String exlpath="C:\\Users\\ADMIN\\eclipse-workspace\\CucumberProjTest\\ExcelData\\ExcelTestData.xlsx";
		String CellData = null;
		try {
			ExcelWSheet.getRow(1).createCell(1).setCellValue(writeData);
			Cell = ExcelWSheet.getRow(1).getCell(1);
			CellData = Cell.getStringCellValue();
			//https://www.softwaretestingmaterial.com/write-excel-files-using-apache-poi/
			FileOutputStream fos = new FileOutputStream(exlpath);
			ExcelWBook.write(fos);
			fos.close();
			System.out.println(CellData);
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
		    if (ExcelFile!=null) {
		    	ExcelFile.close();
		    }
		}
		
//	int lastRow = ExcelWSheet.getLastRowNum();
//	for(int i=0; i<=lastRow; i++){
//	Row row = ExcelWSheet.getRow(i);
//	Cell cell = row.createCell(2);
//
//	cell.setCellValue("Pass");
}
	
	}

