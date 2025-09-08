package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
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
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
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
