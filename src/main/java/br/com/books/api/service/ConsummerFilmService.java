package br.com.books.api.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.books.api.model.Film;

@FeignClient(name = "films-manager", url = "http://localhost:8082")
@RequestMapping("/api/films")
public interface ConsummerFilmService {
	
	@GetMapping(value = "/list")
	List<Film> FindFilmByTitle(@RequestParam String title);

}
