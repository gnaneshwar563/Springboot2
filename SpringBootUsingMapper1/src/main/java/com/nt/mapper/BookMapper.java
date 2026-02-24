package com.nt.mapper;

import org.springframework.stereotype.Component;

import com.nt.dto.BookRequest;
import com.nt.dto.BookResponse;
import com.nt.model.Book;
@Component
public class BookMapper {

	public Book mapToEntity(BookRequest bookrequest) {

		Book book = new Book();
		book.setTitle(bookrequest.getTitle());
		book.setAuthor(bookrequest.getAuthor());
		book.setPrice(bookrequest.getPrice());
	
		return book;

	}
	
	
	public  BookResponse mapToResponse(Book book) {
		BookResponse bookresponse = new BookResponse();
		bookresponse.setAuthor(book.getAuthor());
		bookresponse.setTitle(book.getTitle());
		bookresponse.setPrice(book.getPrice());
		bookresponse.setIsbn(book.getIsbn());
	return bookresponse;
	}

}
/*import org.springframework.beans.BeanUtils;

@Component
public class BookMapper {

    public Book mapToEntity(BookRequest request) {
        Book book = new Book();
        BeanUtils.copyProperties(request, book);
        return book;
    }

    public BookResponse mapToResponse(Book book) {
        BookResponse response = new BookResponse();
        BeanUtils.copyProperties(book, response);
        return response;
    }
}*/