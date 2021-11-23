package br.com.books.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.books.api.dto.DataDTO;
import br.com.books.api.model.Book;
import br.com.books.api.model.Film;
import br.com.books.api.service.BookService;
import br.com.books.api.service.ConsummerFilmService;

@RestController
@RequestMapping("/api/books")
@ResponseBody
public class BookController {
	
	/*Dependences injects*/
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ConsummerFilmService consummerFilmService;

	/*Save endpoint*/
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public Book saveBook (@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	/*Update endpoint*/
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateBook (@PathVariable(name = "id") Long id,  @RequestBody Book book) {
	    bookService.updateBook(id, book);
	}
	
	/*Delete endpoint*/
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete (@PathVariable(name = "id") Long id) {
		bookService.deleteBook(id);
	}
	
	/*List all endpoint*/
	@GetMapping
	public List<Book> listAllBooks() {
		return bookService.listAllBooks();
	}
	
	/*This endpoint is to films-manager API consumes*/
	@GetMapping("/list-books")
	public List<Book> findBookByTitle(String title) {
		return bookService.findBookByTitle(title);
	}
	
	/*List with filter endpoint*/
	@GetMapping("/list")
	public List<DataDTO> listRegisters (@RequestParam String title){
		  return dataBuilder(title);
		
	}
	
	/*This method is to build the informations on DataDTO object */
	private List<DataDTO> dataBuilder (String title) {
	
	if(!title.isEmpty()) {
		
		List<DataDTO> dataCollect = new ArrayList<DataDTO>();
		
		List<Film> listFilm = consummerFilmService.FindFilmByTitle(title);
		
		for (Film film : listFilm) {
			DataDTO dtoFilm = new DataDTO();
			
			dtoFilm.setTitle(film.getTitle());
			dtoFilm.setAuthor(film.getAuthor());
			dtoFilm.setCountry(film.getCountry());
			dtoFilm.setReleaseDate(film.getReleaseDate());
			dtoFilm.setCinematography(film.getCinematography());
			dtoFilm.setType(film.getType());
			
			dataCollect.add(dtoFilm);	
		}
		
		List<Book> listBook = bookService.findBookByTitle(title);
		
		for (Book book : listBook) {
			  DataDTO dtoBook = new DataDTO();
			  
			  dtoBook.setTitle(book.getTitle());
			  dtoBook.setAuthor(book.getAuthor());
			  dtoBook.setCountry(book.getCountry());
			  dtoBook.setReleaseDate(book.getReleaseDate());
			  dtoBook.setPublisher(book.getPublisher());
			  dtoBook.setType(book.getType());
						  
			  dataCollect.add(dtoBook);
		}
		return dataCollect;
	  }
	    return Collections.emptyList();
	}
}
