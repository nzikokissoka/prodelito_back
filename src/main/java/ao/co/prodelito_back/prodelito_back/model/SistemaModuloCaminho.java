package ao.co.prodelito_back.prodelito_back.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_sistemas_modulos_caminhos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SistemaModuloCaminho implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=30)
	private String abreviada;
	
	@Column(length=30)
	private String codigo;
	
	@Column(length=30)
	private String codigoPai;
	
	@Column(length=250)
	private String caminhoFicheiroXhtml;
	
	@Column(length=250)
	private String descricao;
	
	@Column(length=50)
	private String icone;

	@Column(length=250)
	private String componente;

	@Column(length=5)
	private String bloqueioLink;
	
	//-- mêtodos --------------------------------
	public String toStringEntidade() {
		return "SistemaModuloCaminho";
	}
	
	public String toStringTabelaEntidade() {
		return "tb_sistemas_modulos_caminhos";
	}
	
	
}
