package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_asistencia")
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_asistencia")
	int id_asistencia;
	
	@Column(name="estado")
	int estado;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona", referencedColumnName = "id_persona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Socio socio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_seminario", referencedColumnName = "id_seminario")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Seminario seminario;
}
