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
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //Mostrar
    @GetMapping("/mostrar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //Mostrar por ID
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorID(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    //Atualizar
    @PutMapping("/alterarID")
    public String alterarMissao(){
        return "Missao atualizada";
    }

    //Deletar
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }

}
