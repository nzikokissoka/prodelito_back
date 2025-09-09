package ao.co.prodelito_back.prodelito_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ao.co.prodelito_back.prodelito_back.model.GrupoPrivilegio;

@Repository
public interface GrupoPrivilegioRepository extends JpaRepository<GrupoPrivilegio, Integer>{
    
    //--- funcões func100: contagens -------------------------
    @Query(value="SELECT count(*) "
			   + "FROM tb_grupos_de_privilegios", nativeQuery=true)
	public Integer func101CountAll();

    @Query(value="SELECT count(*) "
			   + "FROM tb_grupos_de_privilegios "
               + "WHERE grupo_id = :grupoID", nativeQuery=true)
	public Integer func102CountAll_PorId(@Param("grupoID") Integer grupoID);

    @Query(value="SELECT count(*) "
			   + "FROM tb_grupos_de_privilegios "
               + "WHERE sistema_modulo_caminho_id = :sistemaModuloCaminhoID", nativeQuery=true)
	public Integer func103CountAll_PorSistemaModuloCaminhoId(@Param("sistemaModuloCaminhoID") Integer sistemaModuloCaminhoID); 

    

    //--- funcões func200: Seleciona objecto -----------------
     


    //--- funcões func300: Seleciona lista -------------------
    @Query(value="SELECT * "
			   + "FROM tb_grupos_de_privilegios "
               + "WHERE sistema_modulo_caminho_id = :sistemaModuloCaminhoID and grupo_id = :grupoID", nativeQuery=true)
	public List<GrupoPrivilegio> func301CountAll_Privilegios_PorSMDId_Grupo(@Param("sistemaModuloCaminhoID") Integer sistemaModuloCaminhoID, 
                             @Param("grupoID") Integer grupoID);

    @Query(value="SELECT * "
               + "FROM tb_grupos_de_privilegios "
               + "WHERE codigo like :codigo% and grupo_id = :grupoID", nativeQuery=true)
    public List<GrupoPrivilegio> func302CountAll_Privilegios_PorCodigo_E_Grupo(@Param("codigo") String codigo, @Param("grupoID") Integer grupoID);

}
