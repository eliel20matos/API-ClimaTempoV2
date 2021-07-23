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

import br.com.eliel.domain.Higrometro;
import br.com.eliel.domain.Pluviometro;
import br.com.eliel.repository.HigrometroRepository;

@RestController
@RequestMapping("/api/v1/umidade")
public class HigrometroResource {
	
	private List<Higrometro> higrometro = new ArrayList<>();
	
	@Autowired
	private HigrometroRepository repository;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Higrometro>> listAllHigrometro () {
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll() );
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Higrometro> buscarPorUuid(@PathVariable String uuid) {	
    return ResponseEntity.
  					status(HttpStatus.OK).
   					body( repository.getByUuid(uuid) );

	}
	@PostMapping()
	public ResponseEntity<Higrometro> salvarHigrometro(@RequestBody Higrometro p) {
	return ResponseEntity.
						status(HttpStatus.OK).
						body( this.repository.save(p) );
	}
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirHigrometro(@PathVariable String uuid) {
		Higrometro ane = repository.findByUuid(uuid);
		
		if ( ane != null ) {
			repository.deleteById(ane.getId());
		} 
		
		return ResponseEntity.noContent().build();
	}
	
	

}
