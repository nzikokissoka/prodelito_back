package ao.co.prodelito_back.prodelito_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ao.co.prodelito_back.prodelito_back.model.Grupo;



@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer>{
	
	//--- funcões func100: contagens -------------------------
	@Query(value="SELECT count(*) "
			   + "FROM tb_grupos", nativeQuery=true)
	public Long func101CountAll();

	@Query(value="SELECT count(*) "
			   + "FROM tb_grupos WHERE nome = :nomeSTR", nativeQuery=true)
	public Long func102CountAll_ByNome(@Param("nomeSTR") String nomeSTR);

	@Query(value="SELECT count(*) "
			   + "FROM tb_grupos WHERE visibilidade = :visibilidadeSTR", nativeQuery=true)
	public Long func103CountAll_ByVisibilidade(@Param("visibilidadeSTR") String visibilidadeSTR);
		
	
	//--- funcões func200: Seleciona objecto -----------------
	@Query(value="SELECT * "
			   + "FROM tb_grupos "
			   + "WHERE id = :id", nativeQuery=true)
	public Grupo func201FindOne_ById(@Param("id") Integer id);
	
	@Query(value="SELECT * "
			   + "FROM tb_grupos "
			   + "WHERE nome = :nomeSTR", nativeQuery=true)
	public Grupo func202FindOne_ByNome(@Param("nomeSTR") String nomeSTR);
	
	
	
	//--- funcões func300: Seleciona lista -------------------
	@Query(value="SELECT * "
			   + "FROM tb_grupos", nativeQuery=true)
	public List<Grupo> func301FindAll();
	
	@Query(value="SELECT * "
			   + "FROM tb_grupos "
			   + "ORDER BY nome", nativeQuery=true)
	public List<Grupo> func302FindAll_OrderByNome();
	
	@Query(value="SELECT * "
			   + "FROM tb_grupos "
			   + "WHERE visibilidade = :visibilidadeSTR "
			   + "ORDER BY nome", nativeQuery=true)
	public List<Grupo> func303FindAll_ByVisibilidade(@Param("visibilidadeSTR") String visibilidadeSTR);

	
	@Query(value="SELECT * "
			   + "FROM tb_grupos "
			   + "ORDER BY id DESC", nativeQuery=true)
	public List<Grupo> func304FindAll_OrderByIdDesc();
	
}