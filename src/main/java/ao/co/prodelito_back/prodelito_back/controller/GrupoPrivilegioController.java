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
import ao.co.prodelito_back.prodelito_back.model.GrupoPrivilegio;
import ao.co.prodelito_back.prodelito_back.model.SistemaModuloCaminho;
import ao.co.prodelito_back.prodelito_back.repository.GrupoPrivilegioRepository;
import ao.co.prodelito_back.prodelito_back.repository.GrupoRepository;
import ao.co.prodelito_back.prodelito_back.repository.MenuRepository;
import ao.co.prodelito_back.prodelito_back.repository.SistemaModuloCaminhoRepository;

@RestController
public class GrupoPrivilegioController {

    //injecção de dependencias
    @Autowired private SistemaModuloCaminhoRepository sistemaModuloCaminhoRepository;
    @Autowired private GrupoPrivilegioRepository grupoPrivilegioRepository;
    @Autowired private GrupoRepository grupoRepository;
    @Autowired private MenuRepository menuRepository;


    //funções REST




    //listagens
    @GetMapping("/grupo/listar")
    public Iterable<Grupo> listarTodosGrupos(){
        return grupoRepository.func302FindAll_OrderByNome();
    }

    @GetMapping("/sistemaModuloCaminho/ordenar_por_codigo/{lenCodigo}/{codigoPai}")
    public Iterable<SistemaModuloCaminho> func_listar_todos_ordenar_por_codigo(@PathVariable Integer lenCodigo,
        @PathVariable String codigoPai){
        return sistemaModuloCaminhoRepository.func306FindAll_PorLenCodigo_E_CodigoPai(lenCodigo, codigoPai);
    }

    @GetMapping("/sistemaModuloCaminho/ordenar_por_caminho_not_null/{codigo}")
    public Iterable<SistemaModuloCaminho> func_listar_todos_ordenar_por_caminho_not_null(@PathVariable String codigo){
        return sistemaModuloCaminhoRepository.func307FindAll_PorCaminho_not_null(codigo);
    }


    @GetMapping("/grupoPrivilegio/seleciona_por_smdId_grupoId/{smdId}/{grupoId}")
    public Iterable<GrupoPrivilegio> func_listar_grupo_privilegio_por_smc_grupo(@PathVariable Integer smdId,
            @PathVariable Integer grupoId){
        return grupoPrivilegioRepository.func301CountAll_Privilegios_PorSMDId_Grupo(smdId, grupoId);
    }


    @GetMapping("/grupoPrivilegio/listar_grupo_privilegio_por_codigo_e_grupoId/{codigo}/{grupoId}")
    public Iterable<GrupoPrivilegio> func_listar_grupo_privilegio_por_codigo_grupo(@PathVariable String codigo,
            @PathVariable Integer grupoId){
        return grupoPrivilegioRepository.func302CountAll_Privilegios_PorCodigo_E_Grupo(codigo, grupoId);
    }




    //pegar um objecto sistemaModuloCaminho
    @GetMapping("/sistemaModuloCaminho/pegar_um_objecto/{smcId}/{grupoId}")
    public SistemaModuloCaminho func_pegar_objecto_smc(@PathVariable Integer smcId, @PathVariable Integer grupoId){
        return sistemaModuloCaminhoRepository.func206FindOne_PorSMCId_GrupoId(smcId, grupoId);
    }




    //inserções
    @PostMapping("/grupoPrivilegio/insert")
    public GrupoPrivilegio func_inserir(@RequestBody GrupoPrivilegio grupoPrivilegio){

        //criar e prepara o objecto para inserir
        GrupoPrivilegio grupoPrivilegioInsert = new GrupoPrivilegio(null, 
                grupoPrivilegio.getCodigo(), 
                grupoPrivilegio.getCodigoPai(), 
                grupoPrivilegio.getNovo(), 
                grupoPrivilegio.getCopiar(), 
                grupoPrivilegio.getSalvar(), 
                grupoPrivilegio.getEditar(), 
                grupoPrivilegio.getDeletar(), 
                grupoPrivilegio.getPesquisar(), 
                grupoPrivilegio.getVisibilidade(), 
                grupoPrivilegio.getTempoAtivado(), 
                grupoPrivilegio.getGrupo(), 
                grupoPrivilegio.getSistemaModuloCaminho());

        return grupoPrivilegioRepository.save(grupoPrivilegioInsert);

    }


    // alterar
    @PutMapping("/grupoPrivilegio")
    public GrupoPrivilegio func_alterar(@RequestBody GrupoPrivilegio grupoPrivilegio){

        //criar e prepara o objecto para alterar
        GrupoPrivilegio grupoPrivilegioUpdate = new GrupoPrivilegio(grupoPrivilegio.getId(), 
            grupoPrivilegio.getCodigo(), 
            grupoPrivilegio.getCodigoPai(), 
            grupoPrivilegio.getNovo(), 
            grupoPrivilegio.getCopiar(), 
            grupoPrivilegio.getSalvar(), 
            grupoPrivilegio.getEditar(), 
            grupoPrivilegio.getDeletar(), 
            grupoPrivilegio.getPesquisar(), 
            grupoPrivilegio.getVisibilidade(), 
            grupoPrivilegio.getTempoAtivado(), 
            grupoPrivilegio.getGrupo(), 
            grupoPrivilegio.getSistemaModuloCaminho());

        return grupoPrivilegioRepository.save(grupoPrivilegioUpdate);

    }



    // eliminar
    @DeleteMapping("/grupoPrivilegio/{id}")
    public void func_eliminar(@PathVariable Integer id){
        grupoPrivilegioRepository.deleteById(id);
    }


    
}
