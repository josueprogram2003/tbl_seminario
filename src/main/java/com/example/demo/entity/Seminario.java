package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.sigca.entity.Modulo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_seminario")
public class Seminario {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_seminario")
	int id_seminario;
	@Column(name="fecha_inicio")
	String fecha_inicio;
	@Column(name="fecha_fin")
	String fecha_fin;
	@Column(name="url")
	String url;
	@Column(name="nombre")
	String nombre;
	
	public Seminario(String fecha_inicio, String fecha_fin, String url, String nombre) {
		super();
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.url = url;
		this.nombre = nombre;
	}
	
/*	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seminario")
	private List<Asistencia> asistencia;*/
}
