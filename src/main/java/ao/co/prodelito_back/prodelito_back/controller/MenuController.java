package ao.co.prodelito_back.prodelito_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ao.co.prodelito_back.prodelito_back.model.Grupo;
import ao.co.prodelito_back.prodelito_back.model.Menu;
import ao.co.prodelito_back.prodelito_back.repository.GrupoRepository;
import ao.co.prodelito_back.prodelito_back.repository.MenuRepository;
import ao.co.prodelito_back.prodelito_back.repository.SistemaModuloCaminhoRepository;

@RestController
public class MenuController {

    //injecção de dependencias
    /*@Autowired private SistemaModuloCaminhoRepository sistemaModuloCaminhoRepository;    
    @Autowired private GrupoRepository grupoRepository;*/
    @Autowired private MenuRepository menuRepository;

    /*
        CONTAGEM: func100 ---
        FIND ONE: func200 ---
        FIND ALL: func300 ---
        EXECUÇÃO: func400 ---
    */



    //FIND ALL: func300 --------------------------------

        //func300 Find all -----------------------------
        @GetMapping("/menu")
        public Iterable<Menu> func301_FindAll_PorId(){
            return menuRepository.findAll();
        }

            
    


    //INSERÇÃO: func400 --------------------------------

        //inserção ---------------------
        @PostMapping("/menu")
        public Menu func400_inserir(@RequestBody Menu menu){
            return menuRepository.save(menu);
        }

        

        

    //ALTERAÇÃO: func500 --------------------------------

        //alteração ---------------------
        @PutMapping("/menu")
        public Menu func500_alteracao(@RequestBody Menu menu){
            return menuRepository.save(menu);
        }



    //ELIMINAÇÃO: func600 -------------------------------

        // eliminar ---------------------
        @DeleteMapping("/menu/{id}")
        public void func600_eliminar(@PathVariable Integer id){
            menuRepository.deleteById(id);
        }

    
}
