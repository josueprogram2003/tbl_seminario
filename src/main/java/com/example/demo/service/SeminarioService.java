package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Seminario;


public interface SeminarioService {
	String insertarSeminario (Seminario s);
	List<Seminario> listarSeminario();
	Seminario buscarSeminario(int id_seminario);
	String eliminarSeminario(int id_seminario);
	String actualizarSeminario(Seminario s);
}
