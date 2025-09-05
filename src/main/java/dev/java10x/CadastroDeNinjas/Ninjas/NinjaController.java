package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //CRUD

    //Criar
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    //Mostrar
    @GetMapping("/mostrar")
    public String mostrarNinja(){
        return "Mostrar ninjas";
    }

    //Mostrar por ID
    @GetMapping("/mostrarPorID")
    public String mostrarNinjaPorID(){
        return "Mostrar ninjas por ID";
    }

    //Atualizar
    @PutMapping("/alterar")
    public String alterarNinja(){
        return "Ninja atualizado";
    }

    //Deletar
    @DeleteMapping("/deletarID")
    public String deletarNinja(){
        return "Ninja deletado";
    }
}
