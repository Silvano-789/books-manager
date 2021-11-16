package br.com.books.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.books.api.model.Book;
import br.com.books.api.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    
	@Autowired
	private BookRepository bookRepository;

	/*Save transaction*/
	@Transactional
	public Book saveBook(Book book) {
       return bookRepository.save(book);   
	}

	/*Update transaction*/
	@Transactional
	public void updateBook(Long id, Book book) {
		bookRepository.findById(id)
					  .map(bookExists -> { 
					   book.setId(bookExists.getId());
					   bookRepository.save(book);
					   return book;
					  }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This register don´t exist on database"));
	}

	/*Delete transaction*/
	@Transactional
	public void deleteBook(Long id) {
		bookRepository.findById(id)
					  .map(bookExists -> {
					  bookRepository.delete(bookExists);
					  return Void.TYPE;
					  }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This register don´t exist on database!"));
	}
     
	public List<Book> listAllBooks (){
		return bookRepository.findAll();
	}
	
	/*This method find registers by title for integration */
	public List<Book> findBookByTitle (String title) {
		 return bookRepository.findByTitle(title);
	}

	/*Thi*/
	public Book findBookById(Long id) {
		return bookRepository.findById(id)
				             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The register was not found!"));
	}
}
