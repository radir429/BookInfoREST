package com.test.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.test.demo.vo.BookInfoVO;

@Mapper
public interface BookInfoDAO {
	
	List<BookInfoVO> selectAllBookInfo();
	BookInfoVO selectByKey(String book_key);
	void insert(BookInfoVO bookInfo);
	void update(BookInfoVO bookInfo);
	void delete(String book_key);
	
}
