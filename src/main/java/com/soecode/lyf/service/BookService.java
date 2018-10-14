package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.entity.Book;


public interface BookService {
	
	void addBook(Book book);

	/**
	 * 
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);

	/**
	 * 
	 * 
	 * @return
	 */
	List<Book> getList();


}
