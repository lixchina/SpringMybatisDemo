package appname.bl.dao;

import java.util.List;

import com.gh.mygreen.xlsmapper.annotation.XlsHorizontalRecords;
import com.gh.mygreen.xlsmapper.annotation.XlsSheet;

import appname.bl.entity.Book;

@XlsSheet(number=0)
public class BookDaoQueryAllDatasheet {
	
	@XlsHorizontalRecords(tableLabel="InDto")
    List<Book> bookLst;
	
	public List<Book> getBookLst(){
		return this.bookLst;
	}
}
