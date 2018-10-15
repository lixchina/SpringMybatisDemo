package appname.bl.service;

import java.util.List;

import appname.bl.entity.Book;


public interface BookService {
	
	void addBook(Book book);

	/**
	 * 
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(int bookId);

	/**
	 * 
	 * 
	 * @return
	 */
	List<Book> getList();

	byte[] getCoverByID(int bookId);

}
