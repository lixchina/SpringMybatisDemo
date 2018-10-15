package appname.bl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appname.bl.entity.Book;

import appname.bl.dao.BookDao;
import appname.bl.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
