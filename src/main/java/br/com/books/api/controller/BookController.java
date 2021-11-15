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
import br.com.books.api.service.BookService;
import br.com.books.api.service.ConsummerFilmService;

@RestController
@RequestMapping("/api/books")
@ResponseBody
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ConsummerFilmService consummerFilmService;

	@PostMapping(value = "/save")
	@ResponseStatus (value = HttpStatus.CREATED)
	public Book saveBook (@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@PutMapping(value = "/update/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void updateBook (@PathVariable(name = "id") Long id,  @RequestBody Book book) {
	    bookService.updateBook(id, book);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete (@PathVariable(name = "id") Long id) {
		bookService.deleteBook(id);
	}
	
	@GetMapping(value = "/list-all")
	public List<Book> listAll () {
		return bookService.listAll();
	}
	
	@GetMapping(value = "/list")
	public List<DataDTO> listRegisters (@RequestParam String title){	
		  return dataBuilder(title);
	}
	
private List<DataDTO> dataBuilder (String title) {
		
	if(!title.isEmpty()) {
		
		List<DataDTO> dataCollect = new ArrayList<DataDTO>();
		
		List<Book> listFilm = consummerFilmService.FindFilmByTitle(title);
		DataDTO dtoFilm = new DataDTO();
		for (Book film : listFilm) {
			
			dtoFilm.setTitle(film.getTitle());
			dtoFilm.setAuthor(film.getAuthor());
			dtoFilm.setCountry(film.getCountry());
			dtoFilm.setReleaseDate(film.getReleaseDate());
			dtoFilm.setPublisher(film.getPublisher());
			dtoFilm.setType(film.getType());
			
			dataCollect.add(dtoFilm);	
		}
		
		List<Book> listBook = bookService.findByTitle(title);
		DataDTO dtoBook = new DataDTO();
		for (Book book : listBook) {
			
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
