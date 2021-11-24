package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Seminario;
import com.example.demo.serviceImpl.SeminarioServiceImpl;



@RestController
@RequestMapping("/api/seminario")
public class SeminarioController {
	
	@Autowired
	private SeminarioServiceImpl seminario;
	
	//Funciona
		@GetMapping("/all")
		public ResponseEntity<List<Seminario>> listarSeminario(){
			try {
				List<Seminario> list = new ArrayList<>();
				list=seminario.listarSeminario();
				if (list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list,HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Funciona
		@GetMapping("/search/{id}")
		public ResponseEntity<Seminario> buscarSeminario(@PathVariable("id") int id){
			Seminario s = seminario.buscarSeminario(id);
			if (s.getId_seminario()>0) {
				return new ResponseEntity<>(s,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		
		//Funciona
		@PostMapping("/new")
		public ResponseEntity<String> agregarSeminario(@RequestBody Seminario rec){
			try {
				Seminario r = new Seminario(rec.getFecha_inicio(), rec.getFecha_fin(), rec.getUrl(), rec.getNombre());
				String mensaje= seminario.insertarSeminario(r);
				return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		//Funciona
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> eliminarSeminario(@PathVariable("id") int id){
		try {
			String mensaje = seminario.eliminarSeminario(id);
			return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
		
		//Funciona
		@PutMapping("/update/{id}")
		public ResponseEntity<String> ActualizarSeminario(@RequestBody Seminario rec, @PathVariable("id") int id){
		try {
			Seminario ul = seminario.buscarSeminario(id);
			if (ul.getId_seminario()>0) {
				ul.setNombre(rec.getNombre());
				ul.setUrl(rec.getUrl());
				ul.setFecha_fin(rec.getFecha_fin());
				ul.setFecha_inicio(rec.getFecha_inicio());
				return new ResponseEntity<>(seminario.actualizarSeminario(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
	
}
