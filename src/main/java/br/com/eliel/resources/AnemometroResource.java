package br.com.eliel.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eliel.domain.Anemometro;
import br.com.eliel.repository.AnemometroRepository;

@RestController
@RequestMapping("/api/v1/vel-vento")
public class AnemometroResource {
	
	private List<Anemometro> anemometro = new ArrayList<>();
	
	@Autowired
	private AnemometroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Anemometro>> listAllAnemometro() {			 
		return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.findAll() );
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Anemometro> buscarPorUuid(@PathVariable String uuid) {	
    return ResponseEntity.
  					status(HttpStatus.OK).
   					body( repository.getByUuid(uuid) );
	}
	@PostMapping()
	public ResponseEntity<Anemometro> salvarAnemometro(@RequestBody Anemometro p) {
	return ResponseEntity.
						status(HttpStatus.OK).
						body( this.repository.save(p) );
	}
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirAnemometro(@PathVariable String uuid) {
		Anemometro ane = repository.findByUuid(uuid);
		
		if ( ane != null ) {
			repository.deleteById(ane.getId());
		} 
		
		return ResponseEntity.noContent().build();
	}
	

}
