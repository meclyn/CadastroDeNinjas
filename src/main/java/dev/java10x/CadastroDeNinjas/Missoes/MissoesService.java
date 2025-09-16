package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissaoMapper missaoMapper;

    public MissoesService(MissoesRepository missoesRepository, MissaoMapper missaoMapper) {
        this.missoesRepository = missoesRepository;
        this.missaoMapper = missaoMapper;
    }

    //Listar todas as missões
    public List<MissaoDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    //Listar por ID
    public MissaoDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missaoMapper::map).orElse(null);
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
    public MissaoDTO atualizarMissao(Long id, MissaoDTO MissaoDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missaoMapper.map(MissaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel ninjaSalvo = missoesRepository.save(missaoAtualizada);
            return missaoMapper.map(ninjaSalvo);
        }

        return null;
    }
}
