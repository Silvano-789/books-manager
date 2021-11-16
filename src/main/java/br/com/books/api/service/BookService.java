package br.com.books.api.service;

import java.util.List;

import br.com.books.api.model.Book;

public interface BookService {

	/*Persist a register on database*/
	Book saveBook (Book book);
	
	/*It changes a register on database*/
	void updateBook (Long id ,Book book);
	
	/*It deletes a register on database*/
	void deleteBook (Long id);
	
	/*It list all registers from database*/
	List<Book> listAllBooks ();
	
	/*It list all registers from database by title attribute*/
	List<Book> findBookByTitle (String title);
	
	/*It find a single register by id*/
	Book findBookById (Long id);
}
