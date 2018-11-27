package br.propinanomore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// pesquisa
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Denuncia> todasDenuncias() {
		return dr.findAll();
	}

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Denuncia> listarPorOrgao(@Valid String nome) {
		List<Denuncia> lista = dr.findNome(nome);
		if (lista.size() != 0) {
			return lista;
		} else
			return lista;
	}
	// fim da pesquisa

	// Atualizar
	@PutMapping()
	public String atualizarDenuncia(@Valid Denuncia ob) {
		dr.save(ob);
		return "Denuncia não encontrada!";
	}
	// atualizar denuncia

	// Nova denuncia
	@PostMapping()
	public String salvarDenuncia(@Valid Denuncia ob) {
		dr.save(ob);
		return "Denuncia não encontrada!";
	}
	// fim da nova denuncia

	// remover
	@DeleteMapping()
	public String deletaDenuncia(@Valid long codDenuncia) {
		Denuncia denuncia = dr.findCodDenuncia(codDenuncia);
		if (denuncia != null) {
			dr.delete(denuncia);
			return "Removido com sucesso";
		} else {
			return "Denuncia não encontrada!";
		}
	}
	// fim do remover
}
