package com.test.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.dao.BookInfoDAO;
import com.test.demo.vo.BookInfoVO;

@Service
public class BookInfoServiceImpl implements BookInfoService{
	@Autowired
	BookInfoDAO bookInfoDAO;
	
	@Override
	public List<BookInfoVO> selectAllBookInfo(){
		return bookInfoDAO.selectAllBookInfo();
	}
	
	@Override
	public BookInfoVO selectByKey(String book_key) {
		return bookInfoDAO.selectByKey(book_key);
	}
	
	@Override
	public void insertBookInfo(BookInfoVO bookInfo) {
		bookInfoDAO.insert(bookInfo);
	}
	
	@Override
	public void updateBookInfo(String book_key, BookInfoVO updateBookInfo) {
		BookInfoVO bookInfo = bookInfoDAO.selectByKey(book_key);
		
		if(bookInfo != null) {
			bookInfo.setBook_key(updateBookInfo.getBook_key());
			bookInfo.setBook_reg_no(updateBookInfo.getBook_reg_no());
			bookInfo.setBook_title(updateBookInfo.getBook_title());
			bookInfo.setBook_author(updateBookInfo.getBook_author());
			bookInfo.setBook_publisher(updateBookInfo.getBook_publisher());
			
			bookInfoDAO.update(bookInfo);
		}
		else {
			throw new IllegalStateException("Book does not exist.");
		}
	}
	
	@Override
	public void deleteBookInfo(String book_key) {
		if(bookInfoDAO.selectByKey(book_key) != null) {
			bookInfoDAO.delete(book_key);
		}
		else {
			throw new IllegalStateException("Book does not exist.");
		}
	}
	
}
