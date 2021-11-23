package br.com.books.api.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDTO {
	
	@JsonIgnore
    private Long id;
	
	private String title;

	private String author;

	private String country;

	private String releaseDate;
	
	@JsonInclude(value = Include.NON_NULL)
	private String publisher;
	
	@JsonInclude(value = Include.NON_NULL)
    private String cinematography;

    private String type;
    
  
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataDTO other = (DataDTO) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
