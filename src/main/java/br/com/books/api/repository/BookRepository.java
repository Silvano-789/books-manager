package br.com.books.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.books.api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
	List<Book> findByTitle(String title);
}
