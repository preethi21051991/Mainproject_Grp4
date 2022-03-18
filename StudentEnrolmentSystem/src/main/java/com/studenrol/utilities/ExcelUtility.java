package com.studenrol.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	private static      XSSFWorkbook excelWBook; //Excel WorkBook
    private static      XSSFSheet    excelWSheet; //Excel Sheet
    
    
    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    
    
    public static String getCellData(int RowNum, int ColNum, int SheetNo) throws IOException 
    {     
    	
    	// Open the Excel file
    	 FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                 + "/Testdata.xlsx");
    	 excelWBook = new XSSFWorkbook(ExcelFile);
         excelWSheet = excelWBook.getSheetAt(SheetNo);
         return excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
     }
    
    public static int getIntCellData(int RowNum, int ColNum, int SheetNo) throws IOException 
    {     
    	
    	// Open the Excel file
    	 FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                 + "/Testdata.xlsx");
    	 excelWBook = new XSSFWorkbook(ExcelFile);
         excelWSheet = excelWBook.getSheetAt(SheetNo);
         
         XSSFCell cell = excelWSheet.getRow(RowNum).getCell(ColNum);
         int data = 0;
         
         CellType cellType = cell.getCellType();
         if (cellType.toString() == "BLANK") {
             // let data be null or assign some value like this
        	 return data;
         }
         else if (cellType.toString() == "NUMERIC") {
        	 return data = (int) cell.getNumericCellValue();
          }          
         else
            return data;
     }
    
    

}  
