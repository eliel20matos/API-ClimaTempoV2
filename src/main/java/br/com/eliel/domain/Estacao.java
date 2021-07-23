package br.com.eliel.domain;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Estacao {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	
	
	public Estacao() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "estacao_id")
	@OnDelete(action = OnDeleteAction.CASCADE)//hibernate
	private List<Anemometro> anemometro = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "estacao_id")
	@OnDelete(action = OnDeleteAction.CASCADE)//hibernate
	private List<Higrometro> higrometro = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "estacao_id")
	@OnDelete(action = OnDeleteAction.CASCADE)//hibernate
	private List<Pluviometro> pluviometro = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "estacao_id")
	@OnDelete(action = OnDeleteAction.CASCADE)//hibernate
	private List<Termometro> termometro = new ArrayList<>();
	

}
