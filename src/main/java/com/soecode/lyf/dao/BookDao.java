package com.soecode.lyf.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Book;

public interface BookDao {
	
	void addBook(Book book);

	/**
	 * 閫氳繃ID鏌ヨ鍗曟湰鍥句功
	 * 
	 * @param id
	 * @return
	 */
	Book queryById(long id);

	/**
	 * 鏌ヨ鎵�鏈夊浘涔�
	 * 
	 * @param offset 鏌ヨ璧峰浣嶇疆
	 * @param limit 鏌ヨ鏉℃暟
	 * @return
	 */
	List<Book> queryAll();

	/**
	 * 鍑忓皯棣嗚棌鏁伴噺
	 * 
	 * @param bookId
	 * @return 濡傛灉褰卞搷琛屾暟绛変簬>1锛岃〃绀烘洿鏂扮殑璁板綍琛屾暟
	 */
	int reduceNumber(long bookId);

}
