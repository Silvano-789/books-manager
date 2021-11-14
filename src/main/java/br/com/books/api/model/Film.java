package br.com.books.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
	
	private String title;

	private String author;

	private String country;

	private String releaseDate;

    private String cinematography;

    private String type;
}
