package appname.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import appname.bl.entity.Book;
import appname.bl.service.BookService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration("classpath:/spring/applicationContext.xml"),               
    @ContextConfiguration("classpath:/spring/spring-mvc-ut.xml")}) 
@WebAppConfiguration  
public class BookControllerTest {
	
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();
    
    @InjectMocks
    BookController testClass;
    
    @Mock
    BookService bookService;
	
	MockMvc mockMvc;

    @Before
    public void setUp() {
    	
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        
        // setup
    	List<Book> listBook = new ArrayList<Book>();
    	for(int i=0;i<2;i++){
    		Book book = new Book();
    		book.setBookId(1);
    		book.setName("BookName" + i);
    	}

        when(bookService.getList()).thenReturn(listBook); // (4)

        mockMvc = MockMvcBuilders.standaloneSetup(testClass).setViewResolvers(viewResolver).alwaysDo(log()).build();
    }

    @Test
    public void list_test001() throws Exception {
    	
    	List<Book> listBook = new ArrayList<Book>();
    	for(int i=0;i<2;i++){
    		Book book = new Book();
    		book.setBookId(1);
    		book.setName("BookNameaaa" + i);
    	}
    	
    	MvcResult mvcResult = mockMvc.perform(get("/book/list").param("form", ""))
                // assert
                .andExpect(status().is(200))
                .andExpect(view().name("list"))
                .andExpect(model().attribute("list", listBook))
                .andReturn();

    	// assert
    	verify(bookService).getList();

    }


}
