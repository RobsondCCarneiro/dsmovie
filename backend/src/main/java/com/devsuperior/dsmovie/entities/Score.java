package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

	/*
	 * Aqui eh uma classe de associacao (tabela do BD de Relacionamento de Muitos para Muitos), com um dado extra (value)
	 * Como nao suporta duas referencias (chaves primarias), eh necessario haver mais uma classe extra. 
	 */
	@EmbeddedId
	private ScorePK id = new ScorePK();
	
	//Valor alem da referencia para Movie e para user
	private Double value;

	public Score() {
		
	}
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	public void SetUser(User user) {
		id.setUser(user);
	}
	
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
