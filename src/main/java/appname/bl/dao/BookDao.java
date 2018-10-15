package appname.bl.dao;


import java.util.List;
import appname.bl.entity.Book;

public interface BookDao {
	
	void addBook(Book book);

	Book queryById(int bookId);

	List<Book> queryAll();
	
	byte[] getCoverByID(int bookId);
}
