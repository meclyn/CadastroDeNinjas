package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar por ID
    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar Ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar Ninja
    public void deletarPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    //Editar Ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }


}
