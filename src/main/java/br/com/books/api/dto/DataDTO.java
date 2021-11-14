package br.com.books.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.books.api.model.Book;
import br.com.books.api.model.Film;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {
	
	List<Film> listFilms;
	List<Book> listBooks;
	
	/*
	private String title;

	private String author;

	private String country;

	private String releaseDate;

    private String cinematography;

    private String type;
	*/
}
