package br.propina.controller;

import br.propina.model.Denuncia;
import br.propina.model.Edital;
import br.propina.model.Orgao;
import br.propina.model.Prova;
import br.propina.repository.DenunciaRepository;
import br.propina.repository.EditalRepository;
import br.propina.repository.OrgaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api/v1/denuncia/")
public class DenunciaController {

	@Autowired
	private DenunciaRepository dr;
	@Autowired
	private EditalRepository er;
	@Autowired
	private OrgaoRepository or;

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
	// fim da pesquisa

	// Atualizar
	@PutMapping()
	public String atualizarDenuncia(@Valid Denuncia ob) {
		orgaoPersis(ob.getOrgao(), ob.getEdital().getOrgao_id());
		editalPersis(ob.getEdital());
		dr.save(ob);
		return "Denuncia não encontrada!";
	}
	
	private void editalPersis(Edital edital) {
		if (edital  != null ) er.save(edital); else System.out.println("Denuncia sem denuncia");
	}

	private void orgaoPersis(Orgao orgao, Orgao orgao_id) {
		if (orgao != null)  or.save(orgao); else System.out.println("Orgao vazio!");
		if (orgao_id != null)  or.save(orgao_id); else System.out.println("Orgao edital vazio!");
	}

	// atualizar denuncia

	// Nova denuncia
	@PostMapping()
	public String salvarDenuncia(@RequestBody Denuncia ob) {
		orgaoPersis(ob.getOrgao(), ob.getEdital().getOrgao_id());
		editalPersis(ob.getEdital());
		dr.save(ob);
		return "success";
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
	// fim do remover
    /*@GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return denunciaRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Note noteDetails) {

        Note note = denunciaRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = denunciaRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = denunciaRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        denunciaRepository.delete(note);

        return ResponseEntity.ok().build();
    }*/
}
