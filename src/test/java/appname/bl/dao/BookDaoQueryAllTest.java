package appname.bl.dao;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import appname.bl.dao.base.SanshoDaoTestHelper;
import appname.bl.entity.Book;

public class BookDaoQueryAllTest extends SanshoDaoTestHelper{
	
	@Autowired
	BookDao testClass;

	@Before
    public void setUp() throws Exception {
        super.setUp();
    }
	
	@Test
	public void queryAll_test001(){
		
		
		List<Book> lstBook = testClass.queryAll();
		
		for(Book book:lstBook) {
			System.out.println(book.getName());
		}
		
		assertTrue(1-1==0);	
				
	}

}
