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
    public String criarMissao() {
        return "Missao criada";
    }

    //Mostrar
    @GetMapping("/mostrar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //Mostrar por ID
    @GetMapping("/mostrarPorID")
    public String mostrarMissaoPorID(){
        return "Mostrar missoes por ID";
    }

    //Atualizar
    @PutMapping("/alterarID")
    public String alterarMissao(){
        return "Missao atualizada";
    }

    //Deletar
    @DeleteMapping("/deletarID")
    public String deletarMissao(){
        return "Missao deletada";
    }
}
