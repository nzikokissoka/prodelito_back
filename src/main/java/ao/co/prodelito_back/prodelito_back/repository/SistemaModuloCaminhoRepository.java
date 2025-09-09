package ao.co.prodelito_back.prodelito_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ao.co.prodelito_back.prodelito_back.model.GrupoPrivilegio;
import ao.co.prodelito_back.prodelito_back.model.SistemaModuloCaminho;

@Repository
public interface SistemaModuloCaminhoRepository extends JpaRepository<SistemaModuloCaminho, Integer>{
    
    //--- funcões func100: contagens -------------------------
    @Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos", nativeQuery=true)
	public Integer func101CountAll();

    @Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE LEN(codigo) = :lenCodigo", nativeQuery=true)
	public Integer func102CountAll_PorLenID(@Param("lenCodigo") Integer lenCodigo); //lenID pode ser: 3, 6, 9, 12, 15, 18, 21
    
    @Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE LEN(codigo) = :lenCodigo and codigo = :codigo", nativeQuery=true)
	public Integer func103CountAll_PorLenCodigo_e_Codigo(@Param("lenCodigo") Integer lenCodigo, @Param("codigo") String codigo); //lenID pode ser: 3, 6, 9, 12, 15, 18, 21  

    @Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE LEN(codigo) = :lenCodigo and codigo_pai = :codigoPai", nativeQuery=true)
	public Integer func104CountAll_PorLenCodigo_e_CodigoPai(@Param("lenCodigo") Integer lenCodigo, @Param("codigoPai") String codigoPai); //lenID pode ser: 3, 6, 9, 12, 15, 18, 21
    
    @Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE codigo = :codigo", nativeQuery=true)
	public Integer func105CountAll_PorCodigo(@Param("codigo") String codigo); //lenID pode ser: 3, 6, 9, 12, 15, 18, 21 

    @Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE descricao = :descricao", nativeQuery=true)
	public Integer func106CountAll_PorDescricao(@Param("descricao") String descricao); 

    @Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE abreviada = :abreviada", nativeQuery=true)
	public Integer func107CountAll_PorAbreviada(@Param("abreviada") String abreviada); 

	@Query(value="SELECT count(*) "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE codigo_pai = :codigoPai", nativeQuery=true)
	public Integer func108CountAll_PorCodigoPai(@Param("codigoPai") String codigoPai); //lenID pode ser: 3, 6, 9, 12, 15, 18, 21 




    //--- funcões func200: Seleciona objecto -----------------
    @Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE id = :id", nativeQuery=true)
	public SistemaModuloCaminho func201FindOne_PorId(@Param("id") Integer id);

    @Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE codigo = :codigo", nativeQuery=true)
	public SistemaModuloCaminho func202FindOne_PorCodigo(@Param("codigo") String codigo);

	@Query(value="SELECT MAX(codigo) "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE LEN(codigo) = :lenCodigo", nativeQuery=true)
	public String func203FindOne_MaxCodigo_PorLenCodigo(@Param("lenCodigo") Integer lenCodigo);

	@Query(value="SELECT MAX(codigo) "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE codigo_pai = :codigoPai", nativeQuery=true)
	public String func204FindOne_MaxCodigo_PorCodigoPai(@Param("codigoPai") String codigoPai);

	@Query(value="SELECT MAX(codigo) "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE LEN(codigo) = :lenCodigo and codigo_pai = :codigoPai", nativeQuery=true)
	public String func205FindOne_MaxCodigo_PorLenCodigo_E_CodigoPai(@Param("lenCodigo") Integer lenCodigo, @Param("codigoPai") String codigoPai);



	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
               + "WHERE sistema_modulo_caminho_id = :smcID and grupo_id = :grupoID", nativeQuery=true)
	public SistemaModuloCaminho func206FindOne_PorSMCId_GrupoId(@Param("smcID") Integer smcID, @Param("grupoID") Integer grupoID);


    //--- funcões func300: Seleciona lista -------------------
	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos", nativeQuery=true)
	public List<SistemaModuloCaminho> func301FindAll();

	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE codigo_pai is null and LEN(codigo) = 3", nativeQuery=true)
	public List<SistemaModuloCaminho> func302FindAll_PorLenCodigoPai();

	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE codigo_pai = :codigoPai "
			   + "ORDER BY id DESC", nativeQuery=true)
	public List<SistemaModuloCaminho> func303FindAll_PorCodigoPai(@Param("codigoPai") String codigoPai);

	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "ORDER BY id DESC", nativeQuery=true)
	public List<SistemaModuloCaminho> func304FindAll_PorIdDesc();

	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE LEN(codigo) = :lenCodigo and codigo_pai = :codigoPai "
			   + "ORDER BY id DESC", nativeQuery=true)
	public List<SistemaModuloCaminho> func305FindAll_PorLenCodigo_E_CodigoPai(@Param("lenCodigo") Integer lenCodigo, @Param("codigoPai") String codigoPai);


	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE LEN(codigo) = :lenCodigo and codigo_pai = :codigoPai "
			   + "ORDER BY codigo", nativeQuery=true)
	public List<SistemaModuloCaminho> func306FindAll_PorLenCodigo_E_CodigoPai(@Param("lenCodigo") Integer lenCodigo, @Param("codigoPai") String codigoPai);


	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE caminho_ficheiro_xhtml is not null and codigo LIKE :codigo%", nativeQuery=true)
	public List<SistemaModuloCaminho> func307FindAll_PorCaminho_not_null( @Param("codigo") String codigo);


	@Query(value="SELECT * "
			   + "FROM tb_sistemas_modulos_caminhos "
			   + "WHERE caminho_ficheiro_xhtml is not null and codigo like :codigo% and "
			   + "      id not in (select sistema_modulo_caminho_id "
			   + "                 from tb_grupos_de_privilegios where grupo_id = :grupoID)", nativeQuery=true)
	public List<SistemaModuloCaminho> func308FindAll_PorGrupo_codigo(@Param("grupoID") Integer grupoID, @Param("codigo") String codigo);


}
