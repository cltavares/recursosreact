package br.com.recursosReact.fullstack.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recursosReact.fullstack.domain.GrupoPrioridades;
import br.com.recursosReact.fullstack.repository.GrupoPrioridadesRepository;

@RestController
@RequestMapping("/grupoPrioridades")
//@CrossOrigin(origins = { "http://localhost:3000"})
public class GrupoPrioridadesResource {
	
	@Autowired
	private GrupoPrioridadesRepository grupoPrioridadesRepository;
	
	@GetMapping
	public List<GrupoPrioridades> listarTodas(){
		return grupoPrioridadesRepository.findAll();
	}
	
	@PostMapping
	public GrupoPrioridades cadastrarGrupoPrioridades(@RequestBody GrupoPrioridades grupoPrioridades ) {
		return grupoPrioridadesRepository.save(grupoPrioridades);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<GrupoPrioridades> atualizar(@PathVariable("codigo") Long codigo,  
			@RequestBody GrupoPrioridades grupoPrioridades){
		return grupoPrioridadesRepository.findById(codigo).map(
				record -> {
					BeanUtils.copyProperties(grupoPrioridades, record, "codigo");
					
					GrupoPrioridades grupoPrioridadesSalvo = grupoPrioridadesRepository.save(record);
					
					return ResponseEntity.ok().body(grupoPrioridadesSalvo);
					
				}).orElse(ResponseEntity.notFound().build());		
		
	}
	
	
	@GetMapping("/{codigo}")
	public GrupoPrioridades buscaPeloCodigo(@PathVariable Long codigo) {
		return grupoPrioridadesRepository.findById(codigo).orElse(null);
	}
	
	
	
	

}
