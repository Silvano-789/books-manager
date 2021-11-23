package br.com.books.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film extends BaseBook{
	
	private String title;

	private String author;

	private String country;

	private String releaseDate;
	
	private String cinematography;

    private String type;	    
}
