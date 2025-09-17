package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }
    //CRUD

    //Criar
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao){
        MissaoDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão criada com nome de: " + novaMissao.getNome() + " e com o ID: " + novaMissao.getId());
    }

    //Mostrar
    @GetMapping("/mostrar")
    public ResponseEntity<List<MissaoDTO>> listarMissoes(){
        List<MissaoDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //Mostrar por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarMissaoPorID(@PathVariable Long id){
        MissaoDTO missao = missoesService.listarMissoesPorId(id);
        if (missao != null) {
            return ResponseEntity.ok("Missão encontrada: " + missao.getNome());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " não encontrada");
        }
    }

    //Atualizar


    @PutMapping("/alterar/{id}")
        public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.atualizarMissao(id, missaoAtualizada);
            return ResponseEntity.ok("Informações da missão com o ID: " + id + " atualizada com sucesso");
            } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com o ID " + id + "não encontrada");

        }
    }

    //Deletar
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o ID " + id + " deletada com sucesso" );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com o ID " + id + " não encontrada");

        }
    }

}

