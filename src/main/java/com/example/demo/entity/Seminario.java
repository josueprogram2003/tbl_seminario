package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_seminario")
	int id_seminario;
	@Column(name="fe_fecha_inicio")
	String fecha_inicio;
	@Column(name="fe_fecha_fin")
	String fecha_fin;
	@Column(name="url_link")
	String url;
	@Column(name="no_nombre")
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
