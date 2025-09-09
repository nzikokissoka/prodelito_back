package ao.co.prodelito_back.prodelito_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ao.co.prodelito_back.prodelito_back.repository.AreaRepository;

@RestController
@CrossOrigin(origins = "*")
public class AreaController {
    
    //injecção de dependencias
    @Autowired private AreaRepository areaRepository;

    //contagem
    //conta quantos registros com mesma descrição
    @GetMapping("/area/conta_registros")
    public Long conta_registros(){
        return areaRepository.func101CountAll();
    }

    @GetMapping("/area/conta_por_nome/{nome}")
    public Long conta_registos_por_nome(@PathVariable String nome){
        return areaRepository.func103CountAll_ByNome(nome);
    }

    @GetMapping("/area/conta_por_descrcicao/{descricao}")
    public Long conta_descricao_existente(@PathVariable String descricao){
        return areaRepository.func102CountAll_ByAbreviada(descricao);
    }
 

}
