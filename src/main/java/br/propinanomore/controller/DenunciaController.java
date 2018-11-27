package br.propinanomore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.propinanomore.models.Denuncia;
import br.propinanomore.repository.DenunciaRepository;

@RestController
@RequestMapping("/api/denuncia/")
public class DenunciaController {

	@Autowired
	private DenunciaRepository dr;
	
	@GetMapping(name="/denunciadosTodos",produces="application/json")
	public @ResponseBody Iterable<Denuncia> todasDenuncias() {
		return dr.findAll();
	}
	
	@PostMapping(name="/remover")
	public String deletaDenuncia(@Valid long codDenuncia) {
		Denuncia denuncia = dr.findCodDenuncia(codDenuncia);
		if(denuncia != null) {
			dr.delete(denuncia);
			return "Removido com sucesso";
		}else {
			return "Denuncia não encontrada!";
		}
	}
	
	@GetMapping(name="/buscarPorOrgaos",produces="application/json")
	public @ResponseBody Iterable<Denuncia> listarPorOrgao(@Valid String nome ) {
		List<Denuncia> lista = dr.findNome(nome);
		if(lista.size() != 0) {
			return lista;
		}else
			return lista;
	}
}
