package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AsistenciaRepository;
import com.example.demo.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{
	
	@Autowired AsistenciaRepository asi;
	
	@Override
	public List<Map<String, Object>> listarAsistencia() {
		// TODO Auto-generated method stub
		return asi.listarAsistencia();
	}
	
}
