package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Seminario;
import com.example.demo.repository.SeminarioRepository;
import com.example.demo.service.SeminarioService;

@Service
public class SeminarioServiceImpl implements SeminarioService{
	
	@Autowired
	private SeminarioRepository sr;
	
	@Override
	public String insertarSeminario(Seminario s) {
		// TODO Auto-generated method stub
		return sr.insertarSeminario(s.getNombre(),s.getFecha_inicio(), s.getFecha_fin(), s.getUrl());
	}

	@Override
	public List<Seminario> listarSeminario() {
		// TODO Auto-generated method stub
		return sr.listarSeminario();
	}

	@Override
	public Seminario buscarSeminario(int id_seminario) {
		// TODO Auto-generated method stub
		return sr.buscarSeminario(id_seminario);
	}

	@Override
	public String eliminarSeminario(int id_seminario) {
		// TODO Auto-generated method stub
		return sr.eliminarSeminario(id_seminario);
	}

	@Override
	public String actualizarSeminario(Seminario s) {
		// TODO Auto-generated method stub
		return sr.actualizarSeminario(s.getId_seminario(), s.getNombre(),s.getFecha_inicio(), s.getFecha_fin(), s.getUrl());
	}

}
