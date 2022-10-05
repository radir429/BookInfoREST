package com.test.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.config.SwaggerConfiguration;
import com.test.demo.service.BookInfoServiceImpl;
import com.test.demo.vo.BookInfoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {SwaggerConfiguration.BOOK_TAG})
@RestController
public class BookInfoController {
	@Autowired
	BookInfoServiceImpl bookInfoService;
	
	@ApiOperation(value="도서 목록 조회", notes="도서 목록을 조회한다")
	@GetMapping("/book")
	public List<BookInfoVO> selectAllBookInfo(){
		List<BookInfoVO> allBookInfo = bookInfoService.selectAllBookInfo();
		
		return allBookInfo;
	}
	
	@ApiOperation(value="도서 정보 조회", notes="도서 정보를 조회한다")
	@GetMapping("/book/{book_key}")
	public BookInfoVO selectByKey(@PathVariable String book_key) {
		BookInfoVO bookInfo = bookInfoService.selectByKey(book_key);
		
		return bookInfo;
	}
	
	@ApiOperation(value="도서 목록 추가", notes="도서 정보를 추가한다")
	@PostMapping(value="/book/new")
	public List<BookInfoVO> insertBookInfo(@RequestBody BookInfoVO bookInfo){
		bookInfoService.insertBookInfo(bookInfo);
		
		return bookInfoService.selectAllBookInfo();
	}
	
	@ApiOperation(value="도서 정보 수정", notes="도서 정보를 수정한다")
	@PutMapping(value="/book/{book_key}")
	public List<BookInfoVO> updateBookInfo(@PathVariable String book_key, @RequestBody BookInfoVO bookInfo){
		bookInfoService.updateBookInfo(book_key, bookInfo);
		
		return bookInfoService.selectAllBookInfo();		
	}
	
	@ApiOperation(value="도서 정보 삭제", notes="도서 정보를 삭제한다")
	@DeleteMapping("/book/{book_key}")
	public List<BookInfoVO> deleteBookInfo(@PathVariable String book_key){
		bookInfoService.deleteBookInfo(book_key);
		
		return bookInfoService.selectAllBookInfo();
	}
	
}
