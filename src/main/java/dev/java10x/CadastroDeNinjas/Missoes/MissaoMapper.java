package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {
    public MissoesModel map(MissaoDTO missaoDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missaoDTO.getId());
        missoesModel.setNome(missaoDTO.getNome());
        missoesModel.setDificuldade(missaoDTO.getDificuldade());
        missoesModel.setNinjas(missaoDTO.getNinjas());

        return missoesModel;

    }

    public MissaoDTO map(MissoesModel missoesModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoDTO.getId());
        missaoDTO.setNome(missaoDTO.getNome());
        missaoDTO.setDificuldade(missaoDTO.getDificuldade());
        missaoDTO.setNinjas(missaoDTO.getNinjas());

        return missaoDTO;
    }
}
