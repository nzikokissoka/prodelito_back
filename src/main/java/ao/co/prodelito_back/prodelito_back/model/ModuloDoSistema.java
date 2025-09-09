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
@Table(name = "tb_modulos_do_sistema")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ModuloDoSistema implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=21)
	private String codigo;
	
	@Column(length=21)
	private String codigoPai;
	
	@Column(length=200)
	private String caminhoFicheiroXhtml;
	
	@Column(length=200)
	private String descricao;
	
	@Column(length=50)
	private String icone;
	
	@ManyToOne
	@JoinColumn(name = "sistema_id")
	private Sistema sistema;
	
	//-- mêtodos --------------------------------
	public String toStringEntidade() {
		return "ModuloDoSistema";
	}
	
	public String toStringTabelaEntidade() {
		return "tb_modulos_do_sistema";
	}
	
	
}
