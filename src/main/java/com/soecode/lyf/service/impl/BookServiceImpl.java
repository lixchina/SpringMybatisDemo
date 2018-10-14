package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.soecode.lyf.dao.BookDao;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 娉ㄥ叆Service渚濊禆
	@Autowired
	private BookDao bookDao;
	
	@Override
	public void addBook(Book book) {
		book.setBookId(1);
		book.setNumber(2);
		bookDao.addBook(book);
	}


	@Override
	public Book getById(long bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		return bookDao.queryAll();
	}

}
