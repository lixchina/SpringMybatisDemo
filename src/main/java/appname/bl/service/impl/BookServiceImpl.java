package appname.bl.service.impl;

import java.util.ArrayList;
import java.util.Base64;
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
		bookDao.addBook(book);
	}


	@Override
	public Book getById(int bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		List<Book> list = bookDao.queryAll();
		List<Book> list2 = new ArrayList<Book>();
		for(int i=0;i<list.size();i++) {
			Book book = list.get(i);
			book.setCoverBase64(new String(Base64.getEncoder().encode(book.getCover())));
			list2.add(book);
		};
		return list2;
	}
	
	@Override
	public byte[] getCoverByID(int bookId) {
		return bookDao.getCoverByID(bookId);
	};

}
