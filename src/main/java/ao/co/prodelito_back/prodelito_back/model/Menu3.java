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
@Table(name = "tb_menus3")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Menu3 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=30)
	private String abreviada;
	
	@Column(length=21)
	private String codigo;
	
	@Column(length=21)
	private String codigoPai;
	
	@Column(length=250)
	private String caminhoFicheiroXhtml;
	
	@Column(length=250)
	private String descricao;
	
	@Column(length=50)
	private String icone;

	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;	
	
	@ManyToOne
	@JoinColumn(name = "grupo_privilegio_id")
	private GrupoPrivilegio3 grupoPrivilegio;
	
	@ManyToOne
	@JoinColumn(name = "sistema_modulo_caminho_id")
	private SistemaModuloCaminho sistemaModuloCaminho;

	//-- mêtodos --------------------------------
	
	
}
