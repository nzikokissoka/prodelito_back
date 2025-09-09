package ao.co.prodelito_back.prodelito_back.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_grupos_de_privilegios3")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GrupoPrivilegio3 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=21)
	private String codigo;
	
	@Column(length=21)
	private String codigoPai;
	
	@Column(length=1)
	private Integer novo;
	
	@Column(length=1)
	private Integer copiar;
	
	@Column(length=1)
	private Integer salvar;
	
	@Column(length=1)
	private Integer editar;
	
	@Column(length=1)
	private Integer deletar;
	
	@Column(length=1)
	private Integer pesquisar;
	
	@Column(length=3)
	private String visibilidade;
	
	@Column(length=15)
	private Integer tempoAtivado;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;	
	
	@ManyToOne
	@JoinColumn(name = "sistema_modulo_caminho_id")
	private SistemaModuloCaminho sistemaModuloCaminho;
	
	//-- mêtodos --------------------------------
	public String toStringEntidade() {
		return "GrupoPrivilegio";
	}
	
	public String toStringTabelaEntidade() {
		return "tb_grupos_de_privilegios";
	}
	
}
