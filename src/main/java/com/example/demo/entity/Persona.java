package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
	int id_persona;
	@Column(name="nombre")
	String nombre;
	@Column(name="apellido")
	String apellido;
	@Column(name="telefono")
	String telefono;
	@Column(name="dni")
	String dni;
	@Column(name="correo")
	String correo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Socio socio;
}
