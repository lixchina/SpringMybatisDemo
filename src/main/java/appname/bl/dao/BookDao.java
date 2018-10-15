package appname.bl.dao;


import java.util.List;
import appname.bl.entity.Book;

public interface BookDao {
	
	void addBook(Book book);


	Book queryById(long id);


	List<Book> queryAll();


	int reduceNumber(long bookId);

}
