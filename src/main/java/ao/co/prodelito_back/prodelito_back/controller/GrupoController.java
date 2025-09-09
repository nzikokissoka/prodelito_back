package ao.co.prodelito_back.prodelito_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ao.co.prodelito_back.prodelito_back.model.Grupo;
import ao.co.prodelito_back.prodelito_back.repository.GrupoPrivilegioRepository;
import ao.co.prodelito_back.prodelito_back.repository.GrupoRepository;
import ao.co.prodelito_back.prodelito_back.repository.MenuRepository;

@RestController
@CrossOrigin(origins = "*")
public class GrupoController {
    
    //injecção de dependencias
    @Autowired private GrupoRepository grupoRepository;
    @Autowired private GrupoPrivilegioRepository grupoPrivilegioRepository;
    @Autowired private MenuRepository menuRepository;

    //contagem 
    //conta quantos registros com mesma descrição
    @GetMapping("/grupo/conta_todos_registos")
    public Long conta_registros(){
        return grupoRepository.func101CountAll();
    }

    @GetMapping("/grupo/conta_registos_por_nome/{nome}")
    public Long conta_registos_por_nome(@PathVariable String nome){
        return grupoRepository.func102CountAll_ByNome(nome);
    }

    @GetMapping("/grupo/conta_registos_por_visibilidade/{visibilidadeSTR}")
    public Long conta_descricao_existente(@PathVariable String visibilidadeSTR){
        return grupoRepository.func103CountAll_ByVisibilidade(visibilidadeSTR);
    }


    @GetMapping("/grupo/conta_grupos_em_grupoPrivilegios/{grupoID}")
    public Integer conta_grupos_em_grupoPrivilegios(@PathVariable Integer grupoID){
        return grupoPrivilegioRepository.func102CountAll_PorId(grupoID);
    }

    @GetMapping("/grupo/conta_grupos_em_menus/{grupoID}")
    public Integer conta_grupos_em_menus(@PathVariable Integer grupoID){
        return menuRepository.func102CountAll_PorId(grupoID);
    }


    //listagens
    @GetMapping("/grupo")
    public Iterable<Grupo> listarTodos(){
        return grupoRepository.findAll();
    }

    @GetMapping("/grupo/listar_todos_by_id_desc")
    public Iterable<Grupo> listarTodosOrderByIdDesc (){
        return grupoRepository.func304FindAll_OrderByIdDesc();
    }

    @GetMapping("/grupo/listar_todos_by_nome")
    public Iterable<Grupo> listarTodosOrderByNome (){
        return grupoRepository.func302FindAll_OrderByNome();
    }

    
    //registos   
    @GetMapping("/grupo/listar_um/{id}")
    public Grupo listarUm (@PathVariable Integer id){
        return grupoRepository.func201FindOne_ById(id);
    }


    //insercões
    @PostMapping("/grupo")
    public Grupo inserir(@RequestBody Grupo grupo){

        Grupo grupoInsert = new Grupo(null, null, grupo.getNome(), (grupo.getVisibilidade() == null ? 'N' : 'S'));        
        return grupoRepository.save(grupoInsert);

    }

    // alterar
    @PutMapping("/grupo")
    public Grupo alterar(@RequestBody Grupo grupo){
        return grupoRepository.save(grupo);
    }

    // eliminar
    @DeleteMapping("/grupo/{id}")
    public void eliminar(@PathVariable Integer id){
        grupoRepository.deleteById(id);
    }


}
