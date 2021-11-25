package Day_025_ExcelUtil_Apache_POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;


import org.testng.annotations.Test;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;


public  class TC04_Excel_Test_xlsx
{
		

    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    
    public FileOutputStream fout=null;
    public FileInputStream fis = null;
    


    @Test
    public void hello()throws Exception
    {
    	
    	TC04_Excel_Test_xlsx eat=new TC04_Excel_Test_xlsx();
    	eat.PutCellData( "C://HTML Report//OrangeHRM6//Test62.xlsx","Sheet1",1,0,"Admin11");
    	eat.PutCellData( "C://HTML Report//OrangeHRM6//Test62.xlsx","Sheet1",1,1,"admin11");

    }
    
    
    @Test
    public void hello1()throws Exception
    {
    	
    	TC04_Excel_Test_xlsx eat=new TC04_Excel_Test_xlsx();
    	eat.PutCellData( "C://HTML Report//OrangeHRM6//Test62.xlsx","Sheet2",1,0,"Admin12");
    	eat.PutCellData( "C://HTML Report//OrangeHRM6//Test62.xlsx","Sheet2",1,1,"admin12");

    }
    
    @Test
    public void hello2()throws Exception
    {
    	
    	TC04_Excel_Test_xlsx eat=new TC04_Excel_Test_xlsx();
    	eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport3.xlsx","Sheet3",1,0,"Admin3");
    	eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport3.xlsx","Sheet3",1,1,"admin13");

    }
    
    
    public  synchronized void PutCellData(String xlFilePath,String sheetName,int rowNum,int column,String Text)
    		throws Exception
    {
   
    	  Thread.sleep(15000);
   	 
   	 	fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
    	sheet = workbook.getSheet(sheetName);
    	
    	if(sheet.getRow(rowNum)==null)
    	{
    		row=sheet.createRow(rowNum);
    	}
    	else
    	{
    		row=sheet.getRow(rowNum);
    	}
    	
    	
    	if(row.getCell(column)==null)
    	{
    		cell=row.createCell(column);
    	}
    	else
    	{
    		cell=row.getCell(column);
    	}

   	
    	cell = sheet.getRow(rowNum).getCell(column);  
    	cell.setCellValue(Text);
    	
         
         CellStyle cs1 = workbook.createCellStyle(); 
         cs1.setFillForegroundColor(IndexedColors.WHITE.getIndex()); 
         cs1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
     
         Font font = workbook.createFont();
         font.setColor(IndexedColors.BLUE.getIndex());
         font.setBold(false);
         cs1.setFont(font);
   
    	
    	System.out.println("Text:"+Text);
    	cell.setCellStyle(cs1);
    	cell.setCellValue(Text);
    	
  
    	
    	fout= new FileOutputStream(xlFilePath);
    	workbook.write(fout);
     
        fout.flush();
        fout.close();
        workbook.close();
        fis.close();
        
   	  Thread.sleep(20000);
 
    }
    
    
    
    
    
    
}

