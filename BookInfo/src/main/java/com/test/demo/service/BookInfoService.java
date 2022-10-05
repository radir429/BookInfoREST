package com.test.demo.service;

import java.util.List;
import com.test.demo.vo.BookInfoVO;

public interface BookInfoService {
	List<BookInfoVO> selectAllBookInfo();
	BookInfoVO selectByKey(String book_key);
	void insertBookInfo(BookInfoVO bookInfo);
	void updateBookInfo(String book_key, BookInfoVO bookInfo);
	void deleteBookInfo(String book_key);	

}
