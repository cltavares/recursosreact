package br.com.recursosReact.fullstack.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recursosReact.fullstack.domain.Pessoa;
import br.com.recursosReact.fullstack.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> listarTodas(){
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);		
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable("codigo") Long codigo, @RequestBody Pessoa pessoa){
		return pessoaRepository.findById(codigo).map(
				record -> {
					BeanUtils.copyProperties(pessoa, record,  "codigo");
					Pessoa pessoaAtualizada = pessoaRepository.save(record);
					
					return ResponseEntity.ok().body(pessoaAtualizada);
				}).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/{codigo}")
	public Pessoa buscaPeloCodigo(@PathVariable("codigo") Long codigo ) {
		return pessoaRepository.findById(codigo).orElse(null);
	}
	

}
