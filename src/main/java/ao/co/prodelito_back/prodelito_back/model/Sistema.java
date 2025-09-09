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
@Table(name = "tb_sistemas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Sistema  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=21)
	private String codigo;
	
	@Column(length=25)
	private String abreviada;
	
	@Column(length=150)
	private String nome;
	
	@Column(length=250)
	private String pagina;
	
	//-- mêtodos --------------------------------
	public String toStringNomeCompletoSistema() {
		return "("+abreviada+") "+nome;
	}
	
	public String toStringEntidade() {
		return "Sistema";
	}
	
	public String toStringTabelaEntidade() {
		return "tb_sistemas";
	}

}
