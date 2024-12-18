package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")

public class Postagens {

	@Id // chave primária no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue é a auto incremente no banco de dados
	private Long id;

	@NotBlank(message = " O preenchimento é obrigatório ")
	@Size(min = 5, max = 100)
	private String titulo;

	@NotBlank(message = " O preenchimento é obrigatório ")
	@Size(min = 10, max = 1000)
	private String texto;

	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema tema;// essa variavel tema pertence ao objeto Tema
	
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Usuario usuario;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
