package br.com.eliel.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eliel.domain.Higrometro;

@Repository
public interface HigrometroRepository extends JpaRepository<Higrometro, Long>{
	
	Higrometro getByUmidade(String umidade);
	 
	Higrometro getByUuid(String uuid);
	
	Higrometro getByregistroData(Date registroData);
	
	Higrometro findByUuid(String uuid);
	
	void deleteByUuid(String uuid);

}
