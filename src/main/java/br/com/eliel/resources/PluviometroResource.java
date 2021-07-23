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

import br.com.eliel.domain.Pluviometro;
import br.com.eliel.repository.PluviometroRepository;

@RestController
@RequestMapping("/api/v1/precipitacao")
public class PluviometroResource {
	
	private List<Pluviometro> anemometro = new ArrayList<>();
	
	@Autowired
	private PluviometroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pluviometro>> listAllPluviometro() {			 
		return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.findAll() );
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Pluviometro> buscarPorUuid(@PathVariable String uuid) {	
    return ResponseEntity.
  					status(HttpStatus.OK).
   					body( repository.getByUuid(uuid) );
	}
	@PostMapping()
	public ResponseEntity<Pluviometro> salvarAnemometro(@RequestBody Pluviometro p) {
	return ResponseEntity.
						status(HttpStatus.OK).
						body( this.repository.save(p) );
	}
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirPluviometro(@PathVariable String uuid) {
		Pluviometro ane = repository.findByUuid(uuid);
		
		if ( ane != null ) {
			repository.deleteById(ane.getId());
		} 
		
		return ResponseEntity.noContent().build();
	}
	

}
