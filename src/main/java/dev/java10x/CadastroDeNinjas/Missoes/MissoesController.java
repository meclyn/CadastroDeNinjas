package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //CRUD

    //Criar
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada";
    }

    //Mostrar
    @GetMapping("/mostrarID")
    public String mostrarMissao(){
        return "Mostrar missao";
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
