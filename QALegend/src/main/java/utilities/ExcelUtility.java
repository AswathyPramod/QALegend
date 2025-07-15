package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;  //to take details from file
	static XSSFWorkbook wb; //to take details from workbook
	static XSSFSheet   sh; // to take details from sheet
	public static String getStringData(int a, int b,String filePath,String sheetName) throws IOException
	{
		String path=System.getProperty("user.dir")+filePath;
		f=new FileInputStream(path);
		wb=new XSSFWorkbook(f); 
		sh= wb.getSheet(sheetName);// method to take details from sheet
		XSSFRow r=sh.getRow(a);// method to take value from row
		XSSFCell c=r.getCell(b);//method to getvalue from the cell
		return c.getStringCellValue();
	}
	public static String getIntegerData(int a, int b,String filePath,String sheetName) throws IOException
	{
		String path=System.getProperty("user.dir")+filePath;
		f=new FileInputStream(path);
		wb=new XSSFWorkbook(f);
		sh= wb.getSheet(sheetName);// method to take details from sheet
		XSSFRow r=sh.getRow(a);// method to take value from row
		XSSFCell c=r.getCell(b);//method to getvalue from the cell
		int x=(int)c.getNumericCellValue();
		return String.valueOf(x);
		
	}
	
		
	


}
