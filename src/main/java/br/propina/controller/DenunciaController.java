package br.propina.controller;

import br.propina.model.Denuncia;
import br.propina.model.Edital;
import br.propina.model.Orgao;
import br.propina.model.Prova;
import br.propina.repository.DenunciaRepository;
import br.propina.repository.EditalRepository;
import br.propina.repository.OrgaoRepository;
import br.propina.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/denuncia/")
public class DenunciaController {

	@Autowired
	private DenunciaRepository dr;
	@Autowired
	private EditalRepository er;
	@Autowired
	private OrgaoRepository or;
	@Autowired
	private ProvaRepository pr;

	// pesquisa
	@GetMapping()
	public List<Denuncia> todasDenuncias() {
		return dr.findAll();
	}

	@GetMapping("{nome}")
	public List<Denuncia> listarPorOrgao(@PathVariable(value = "nome") String nome) {
		List<Denuncia> lista = dr.findnome(nome);
		if (lista.size() != 0) {
			return lista;
		} else
			return lista;
	}

	@GetMapping("top")
	public List<Orgao> listarTop() {
		List<Orgao> lista = or.findTopDenuncia();
		return lista;
	}
	// fim da pesquisa

	// Atualizar
	@PutMapping()
	public String atualizarDenuncia(@Valid Denuncia ob) {
		ob.setOrgao(orgaoPersis(ob.getOrgao()));
		ob.setEdital(editalPersis(ob.getEdital()));
		dr.save(ob);
		return "success";

	}

	private Edital editalPersis(Edital edital) {
		if (edital != null) {
			Edital ed = er.findByreferencia(edital.getReferencia());
			if (ed == null) {
				Orgao orgao = orgaoPersis(edital.getOrgao_id());
				edital.setOrgao_id(orgao);
				ed = er.save(edital);
			}
			return ed;
		}
		return null;
	}

	private Orgao orgaoPersis(Orgao orgao) {
		if (orgao != null) {
			Orgao ob = or.findBynome(orgao.getNome());	
			
			if (ob == null) {
				System.out.println(orgao.getNome());
				ob = or.save(orgao);
			}
			return ob;
		}
		return null;
	}

	// atualizar denuncia

	// Nova denuncia
	@PostMapping()
	public String salvarDenuncia(@RequestBody Denuncia ob) {

		ob.setOrgao(orgaoPersis(ob.getOrgao()));
		ob.setEdital(editalPersis(ob.getEdital()));
		dr.save(ob);
		return "success";
	}

	@PostMapping("arquivo")
	private Prova provaPersis(MultipartFile prova) {
		System.out.println();
		try {
			Prova filemode = pr.save(new Prova(prova.getOriginalFilename(), prova.getBytes(), prova.getContentType()));
			return filemode;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("arquivo")
	private List<Prova> getProvas() {
		return pr.findAll();
	}

	@GetMapping("arquivo/")
	private ResponseEntity<byte[]> getProvas(Long codProva) {
		Optional<Prova> fileOptional = pr.findById(codProva);

		if (fileOptional.isPresent()) {
			Prova file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getNome() + "\"")
					.body(file.getArquivo());
		}

		return ResponseEntity.status(404).body(null);
	}
	// fim da nova denuncia

	// remover
	@DeleteMapping()
	public String deletaDenuncia(@Valid long codDenuncia) {
		Denuncia denuncia = dr.findcodDenuncia(codDenuncia);
		if (denuncia != null) {
			dr.delete(denuncia);
			return "Removido com sucesso";
		} else {
			return "Denuncia não encontrada!";
		}
	}
}
