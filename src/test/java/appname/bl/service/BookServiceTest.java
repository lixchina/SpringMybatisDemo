package appname.bl.service;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import appname.bl.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/serviceTestApplicationContext.xml")
public class BookServiceTest{
	
	@Autowired
	BookService testClass;

	@Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void getList_test001() {		
		
		List<Book> lstBook = testClass.getList();
		
		for(Book book:lstBook) {
			System.out.println(book.getName());
		}
		
		assertTrue(1-1==0);
		
	}

}
