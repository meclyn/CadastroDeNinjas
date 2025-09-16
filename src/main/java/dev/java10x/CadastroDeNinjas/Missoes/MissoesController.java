package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
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
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao){
        return missoesService.criarMissao(missao);
    }

    //Mostrar
    @GetMapping("/mostrar")
    public List<MissaoDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //Mostrar por ID
    @GetMapping("/listar/{id}")
    public MissaoDTO listarMissaoPorID(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    //Atualizar
    @PutMapping("/alterarID")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada){
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    //Deletar
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }

}
