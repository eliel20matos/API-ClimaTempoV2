package br.com.eliel.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eliel.domain.Pluviometro;


@Repository
public interface PluviometroRepository extends JpaRepository<Pluviometro, Long>{
	
	Pluviometro getByPrecipitacao(String precipitacao);
	 
	Pluviometro getByUuid(String uuid);
	
	Pluviometro getByregistroData(Date registroData);
	
	Pluviometro findByUuid(String uuid);
	
	void deleteByUuid(String uuid);

}
