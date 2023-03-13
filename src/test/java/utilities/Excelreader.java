package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {   
	public  String sheetname;
	public   Map<String, String> userme;
	public  List<String> password;
	public  String invalidusernmame;
	public  String invalidpassword;

	public  String password1;
	
	
	
	public Excelreader(String sheetname) {
		 this.sheetname=sheetname;
	}
	
	

	public  Map<String, String> username(){
	
	    File excelfile = new File("C:\\Users\\amitf\\eclipse-workspace\\Jobinterview\\Walmart\\src\\test\\resources\\Test Data\\swaglab.xlsx");
		 FileInputStream readfile = null;
		 XSSFSheet sheet = null;
		try {  
			readfile = new FileInputStream(excelfile);
		} catch (FileNotFoundException e) {
			System.out.println("Excel file not found");
			e.printStackTrace();
		}
			try {
				XSSFWorkbook book = new XSSFWorkbook(readfile);
				 sheet = book.getSheet( this.sheetname);		
			} catch (IOException e) {
				System.out.println("IO Exception to read file");
				e.printStackTrace();
			}

			int rowcount = sheet.getLastRowNum();
			System.out.println(rowcount);
			 userme= new HashMap<String, String>();
			for(int i=0; i<=rowcount; i++) {
				Row selectedrow = sheet.getRow(i);	
					 Cell cell= selectedrow.getCell(0);
					 DataFormatter df = new DataFormatter();
					 String key=df.formatCellValue(cell);
					 Cell cell1= selectedrow.getCell(1);
					 String value = df.formatCellValue(cell1);
					 userme.put(key, value);
					
			}
			return userme;
			
		
			
			
			
//			 Iterator<String> itr = username.iterator();
//		        while(itr.hasNext()){
//		            System.out.println("arrayList values: "+itr.next());
//		        }
			
		
			
			}
				
		
				

//								}
	public List<String> password(){
		
	    File excelfile = new File("C:\\Users\\amitf\\eclipse-workspace\\Jobinterview\\Walmart\\src\\test\\resources\\Test Data\\swaglab.xlsx");
		 FileInputStream readfile = null;
		 XSSFSheet sheet = null;
		try {  
			readfile = new FileInputStream(excelfile);
		} catch (FileNotFoundException e) {
			System.out.println("Excel file not found");
			e.printStackTrace();
		}
			try {
				XSSFWorkbook book = new XSSFWorkbook(readfile);
				 sheet = book.getSheet(this.sheetname);		
			} catch (IOException e) {
				System.out.println("IO Exception to read file");
				e.printStackTrace();
			}

			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(0).getLastCellNum();
			for(int i=0; i<=rowcount; i++) {
				Row selectedrow = sheet.getRow(i);
					 password= new ArrayList<String>();
					 DataFormatter df = new DataFormatter();
					 password.add(df.formatCellValue(selectedrow.getCell(1)));
					 
					 
			}
			return password;
			}
				
					}
		

		
		
	
	

	


