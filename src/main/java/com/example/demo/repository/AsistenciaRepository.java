package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{
	@Query(value = "select concat(tp.nombre,' ',tp.apellido) as nombre , ts.no_nombre, ta.estado from tbl_seminario ts join tbl_asistencia ta on ts.id_seminario=ta.id_seminario\r\n"
			+ "join tbl_socio tso on ta.id_persona =tso.id_persona  join tbl_persona tp  on tso.id_persona =tp.id_persona;", nativeQuery = true)
	List<Map<String,Object>> listarAsistencia();
}
