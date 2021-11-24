package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Seminario;

@Repository
public interface SeminarioRepository extends JpaRepository<Seminario, Integer>{
	
	// Listar
		@Query(value = "{ CALL SP_LISTA_TBL_SEMINARIO()}", nativeQuery = true)
		List<Seminario> listarSeminario();
		
		// Buscar
		@Query(value = "{ CALL SP_BUSCAR_TBL_SEMINARIO ;(:p_nID_SEMINARIO ) }", nativeQuery = true)
		Seminario buscarSeminario(@Param("p_nID_SEMINARIO ") int p_nID_SEMINARIO );
		
		// Delete
		@Query(value = "{ CALL SP_DEL_TBL_SEMINARIO(:p_nID_SEMINARIO  ) }", nativeQuery = true)
		String eliminarSeminario(@Param("p_nID_SEMINARIO  ") int p_nID_SEMINARIO  );
		
		// Insertar
		@Query(value = "{call SP_INS_TBL_SEMINARIO(:p_vNO_NOMBRE,:p_dFE_INICIO,:p_dFE_FIN,:p_vURL_LINK)}", nativeQuery = true) 
		String insertarSeminario(@Param("p_vNO_NOMBRE") String p_vNO_NOMBRE,@Param("p_dFE_INICIO") String p_dFE_INICIO, @Param("p_dFE_FIN") String p_dFE_FIN, @Param("p_vURL_LINK") String p_vURL_LINK);
		
		//Actualizar
		@Query(value = "{call SP_UPD_TBL_SEMINARIO(:p_nID_SEMINARIO , :p_vNO_NOMBRE,:p_dFE_INICIO , :p_dFE_FIN , :p_vURL_LINK )}", nativeQuery = true) 
		String actualizarSeminario(@Param("p_nID_SEMINARIO") int p_nID_SEMINARIO , @Param("p_vNO_NOMBRE") String p_vNO_NOMBRE,@Param("p_dFE_INICIO") String p_dFE_INICIO, @Param("p_dFE_FIN") String p_dFE_FIN, @Param("p_vURL_LINK") String p_vURL_LINK);

	
}
