package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissaoMapper missaoMapper;

    public MissoesService(MissoesRepository missoesRepository, MissaoMapper missaoMapper) {
        this.missoesRepository = missoesRepository;
        this.missaoMapper = missaoMapper;
    }

    //Listar todas as missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar por ID
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //Criar Missao
    public MissaoDTO criarMissao(MissaoDTO missoesDTO){
        MissoesModel missao = missaoMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missaoMapper.map(missao);
    }

    //Deletar Missao
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //Editar Missao

}
