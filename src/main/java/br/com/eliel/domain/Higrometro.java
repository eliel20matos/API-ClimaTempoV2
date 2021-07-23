package br.com.eliel.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Higrometro {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String Coordenadas;
	
	@NotNull(message = "A umidade não pode ser nula!")
	private String umidade;
	
	@NotNull(message = "A data não pode ser nula!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date registroData;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("uuid")
	@Column(name = "ext_uuid", 
	        updatable = false, 
	        columnDefinition = "varchar(36) not null")
    private String uuid;
	
	@NotNull
	private String lat;
	
	@NotNull
	private String longi;
	
	
	public Higrometro() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUmidade() {
		return umidade;
	}


	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}


	public Date getRegistroData() {
		return registroData;
	}


	public void setRegistroData(Date registroData) {
		this.registroData = registroData;
	}


	public String getUuid() {
		return uuid;
	}

	
}
