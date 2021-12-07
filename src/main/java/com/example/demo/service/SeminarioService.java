package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Seminario;


public interface SeminarioService {
	Seminario insertarSeminario (Seminario s);
	List<Seminario> listarSeminario();
	Seminario buscarSeminario(int id_seminario);
	void eliminarSeminario(int id_seminario);
	Seminario actualizarSeminario(Seminario s);
}
