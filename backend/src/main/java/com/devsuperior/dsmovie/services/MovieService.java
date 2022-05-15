package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
/*
 * O autowired serve para que se instancia automaticamente
 * Pois, o Framework ja tem o gerenciamento de dependencia
 */
	@Autowired
	private MovieRepository repository;
/*
 * A comunicacao entre o servico e o controlador REST
 * eh feita por DTO, por isso que utilizamos o tipo do
 * retorno como MovieDTO ao inves de Movie.
 * O pageable eh para limitar a buscar em uma quantidade
 * fixa de elementos por vez.
 */
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
