package com.nt.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.constants.bookconstants;
import com.nt.dto.BookRequest;
import com.nt.dto.BookResponse;
import com.nt.exception.BookNotFoundException;
import com.nt.mapper.BookMapper;
import com.nt.model.Book;
import com.nt.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookRepository;
//	@Autowired
//	private ModelMapper mapper;
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private bookconstants bookConstants;

	@Override
	public void addBook(BookRequest bookRequest) {
		Book book = bookMapper.mapToEntity(bookRequest);
		book.setIsbn(generateIsbn());
		bookRepository.save(book);
	}

	@Override
	public void update(BookRequest bookrequest) {
		Book book = bookMapper.mapToEntity(bookrequest);
		book.setIsbn(generateIsbn());
		bookRepository.save(book);

	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);

	}

//	@Override
//	public BookResponse getById(int bookId) {
//		try {
//			Book book = bookRepository.findById(bookId)
//					.orElseThrow(() -> new RuntimeException(bookConstants.BOOK_NOT_FOUND_WITH_ID + bookId));
//			BookResponse bookresponse = bookMapper.mapToResponse(book);
//			return bookresponse;
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//
//		}
//	}
	public BookResponse getById(int bookId) {

		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException(bookConstants.BOOK_NOT_FOUND_WITH_ID + bookId));

	    return bookMapper.mapToResponse(book);
	}

	@Override
	public List<BookResponse> getAll() {
		List<Book> books = bookRepository.findAll();

		return books.stream().map(book -> bookMapper.mapToResponse(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookResponse> getByAuthor(String author) {
		List<Book> books = bookRepository.findByAuthor(author);

		return books.stream().map(book -> bookMapper.mapToResponse(book)).toList(); // Java 16+
	}

	private String generateIsbn() {
		return "ISBN-" + UUID.randomUUID().toString().substring(0, 13);
	}

}
