package br.com.books.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.books.api.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	/*Method used on integration*/
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
	List<Book> findByTitle(String title);
}
