package ao.co.prodelito_back.prodelito_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ao.co.prodelito_back.prodelito_back.model.Area;



@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{
	
	//--- funcões func100: contagens -------------------------
	@Query(value="SELECT count(*) "
			   + "FROM tb_areas", nativeQuery=true)
	public Long func101CountAll();

	@Query(value="SELECT count(*) "
			   + "FROM tb_areas WHERE abreviada = :abreviadaSTR", nativeQuery=true)
	public Long func102CountAll_ByAbreviada(@Param("abreviadaSTR") String abreviadaSTR);

	@Query(value="SELECT count(*) "
			   + "FROM tb_areas WHERE nome = :nomeSTR", nativeQuery=true)
	public Long func103CountAll_ByNome(@Param("nomeSTR") String nomeSTR);
		
	
	//--- funcões func200: Seleciona objecto -----------------
	@Query(value="SELECT * "
			   + "FROM tb_areas "
			   + "WHERE id = :id", nativeQuery=true)
	public Area func201FindOne_ById(@Param("id") Integer id);
	
	@Query(value="SELECT * "
			   + "FROM tb_areas "
			   + "WHERE abreviada = :abreviadaSTR", nativeQuery=true)
	public Area func202FindOne_ByAbreviada(@Param("abreviadaSTR") String abreviadaSTR);
	
	
	@Query(value="SELECT * "
			   + "FROM tb_areas "
			   + "WHERE nome = :nomeSTR", nativeQuery=true)
	public Area func203FindOne_ByNome(@Param("nomeSTR") String nomeSTR);
	
	
	
	//--- funcões func300: Seleciona lista -------------------
	@Query(value="SELECT * "
			   + "FROM tb_areas", nativeQuery=true)
	public List<Area> func301FindAll();
	
	@Query(value="SELECT * "
			   + "FROM tb_areas "
			   + "ORDER BY nome", nativeQuery=true)
	public List<Area> func302FindAll_OrderByNome();
	
	@Query(value="SELECT * "
			   + "FROM tb_areas "
			   + "WHERE nome LIKE :nomeSTR% "
			   + "ORDER BY nome", nativeQuery=true)
	public List<Area> func303FindAll_ByNome(@Param("nomeSTR") String nomeSTR);
	 
	
}