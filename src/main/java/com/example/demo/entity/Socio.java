package com.example.demo.entity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_socio")
public class Socio {
	
	@Id
	@Column(name = "id_persona")
	private int id_persona;
	
	@Column(name = "id_banco")
	private int id_banco;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Persona persona;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<Asistencia> asistencia;
}
