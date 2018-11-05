package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class JUnitDataReader2 {
	
	private String fileName;
	private String inDtoClassName;
	private List<String> colList;
	final String INDTO = "InDto";
	final String EXPECT_OUTDTO = "OutDto期待値";
	
	
	public JUnitDataReader2(String fileName){
		this.fileName = fileName;
		colList = new ArrayList<String>();
	}
	
	public void readInDto() throws InvalidFormatException, IOException{
	
		Workbook workbook = WorkbookFactory.create(
				getClass().getClassLoader().getResourceAsStream(fileName));
		
		// 最初のシートを取得
		Sheet sheet = workbook.getSheetAt(0);
	
		// 全行を繰り返し処理する場合
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()) {
		  Row row = rows.next();
		  Cell cell = row.getCell(1);
		  if(INDTO.equals(cell.getStringCellValue())) {
			  row = rows.next();
			  inDtoClassName = row.getCell(2).getStringCellValue();
			  System.out.println(inDtoClassName);
			  
			  row = rows.next();
			  row = rows.next();
			  Iterator<Cell> cells = row.cellIterator();
			  while(cells.hasNext()) {
				    Cell colCell = cells.next();
				    if(colCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				    	colList.add(colCell.getStringCellValue());
				    }
			  }
			  break;
		  }
		  
		  // 全セルを繰り返し処理する場合
		  /*Iterator<Cell> cells = row.cellIterator();
		  while(cells.hasNext()) {
		    Cell cell = cells.next();
		    
		   
		    
		    switch(cell.getCellType()) {
		    // 数値
            //日付も数値として判定される
		    case Cell.CELL_TYPE_NUMERIC:
		    	System.out.println(cell.getNumericCellValue());
		      break;
		    // 文字列
		    case Cell.CELL_TYPE_STRING:
		    	System.out.println(cell.getStringCellValue());
		    	
		      break;
		    // Blank
		    case Cell.CELL_TYPE_BLANK:
		    	break;
		    default:
		    	System.out.println(cell.getStringCellValue());
		      break;
		  }
		    
		  }*/
		}
		
	}
	
	public static void main(String[] args){
		JUnitDataReader2 dr = new JUnitDataReader2("dbunit/BookDaoQueryAllTest/queryAll_data.xlsx");
		try {
			dr.readInDto();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
