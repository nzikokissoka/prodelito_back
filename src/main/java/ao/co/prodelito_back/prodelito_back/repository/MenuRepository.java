package ao.co.prodelito_back.prodelito_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ao.co.prodelito_back.prodelito_back.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
    
    //--- funcões func100: contagens -------------------------
    @Query(value="SELECT count(*) "
			   + "FROM tb_menus", nativeQuery=true)
	public Integer func101CountAll();

    @Query(value="SELECT count(*) "
			   + "FROM tb_menus "
               + "WHERE grupo_id = :grupoID", nativeQuery=true)
	public Integer func102CountAll_PorId(@Param("grupoID") Integer grupoID);    

    @Query(value="SELECT count(*) "
			   + "FROM tb_menus "
               + "WHERE sistema_modulo_caminho_id = :sistemaModuloCaminhoID", nativeQuery=true)
	public Integer func103CountAll_PorSistemaModuloCaminhoId(@Param("sistemaModuloCaminhoID") Integer sistemaModuloCaminhoID); 

    //--- funcões func200: Seleciona objecto -----------------
    @Query(value="SELECT * "
			   + "FROM tb_menus "
               + "WHERE sistema_modulo_caminho_id = :sistemaModuloCaminhoID", nativeQuery=true)
	public Integer func201FindOne_PorSistemaModuloCaminhoId(@Param("sistemaModuloCaminhoID") Integer sistemaModuloCaminhoID); 


    //--- funcões func300: Seleciona lista -------------------


}
