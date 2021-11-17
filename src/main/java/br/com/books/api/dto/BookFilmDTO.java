package br.com.books.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BookFilmDTO {

	@JsonInclude(value = Include.NON_NULL)
    private String publisher;
	@JsonInclude(value = Include.NON_NULL)
    private String cinematography;
}
