package com.nt.service;

import java.util.List;

import com.nt.dto.BookRequest;
import com.nt.dto.BookResponse;

public interface IBookService {

	void addBook(BookRequest bookrequest);

	void update(BookRequest bookrequest);

	void deleteBook(int bookId);

	// querying
	BookResponse getById(int bookId);

	List<BookResponse> getAll();

	List<BookResponse> getByAuthor(String author);

}
