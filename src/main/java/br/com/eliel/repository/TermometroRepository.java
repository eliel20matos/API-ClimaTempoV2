package br.com.eliel.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eliel.domain.Termometro;

@Repository
public interface TermometroRepository extends JpaRepository<Termometro, Long>{
	
	Termometro getByTemperatura(String temperatura);
	 
	Termometro getByUuid(String uuid);
	
	Termometro getByregistroData(Date registroData);
	
	Termometro findByUuid(String uuid);
	
	void deleteByUuid(String uuid);

}
