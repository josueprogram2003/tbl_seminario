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
	public Seminario insertarSeminario(Seminario s) {
		// TODO Auto-generated method stub
		//return sr.insertarSeminario(s.getNombre(),s.getFecha_inicio(), s.getFecha_fin(), s.getUrl());
		
		return sr.save(s);
	}

	@Override
	public List<Seminario> listarSeminario() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Seminario buscarSeminario(int id_seminario) {
		// TODO Auto-generated method stub
		//return sr.buscarSeminario(id_seminario);
		return sr.findById(id_seminario).get();
	}

	@Override
	public void eliminarSeminario(int id_seminario) {
		// TODO Auto-generated method stub
		//return sr.eliminarSeminario(id_seminario);
		 sr.deleteById(id_seminario);
	}

	@Override
	public Seminario actualizarSeminario(Seminario s) {
		// TODO Auto-generated method stub
		//return sr.actualizarSeminario(s.getId_seminario(), s.getNombre(),s.getFecha_inicio(), s.getFecha_fin(), s.getUrl());
		return sr.save(s);
	}

}
