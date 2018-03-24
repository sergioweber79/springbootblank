package br.com.springboot.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tamanho")
public class Tamanho extends BaseDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4225126005138083872L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtamanho")
	private Integer idTamanho;
	@Column(name="dsc_tamanho")
	private String dscTamanho;
	@Column(name="sigla")
	private String sigla;
	
	
	public Tamanho() {
		
	}

	public Tamanho(Integer id,String descricao, String sigla) {
		this.idTamanho=id;
		this.dscTamanho=descricao;
		this.sigla=sigla;
	}
	
	public Tamanho(String descricao, String sigla) {
		
		this.dscTamanho=descricao;
		this.sigla=sigla;
	}
	
	public Integer getIdTamanho() {
		return idTamanho;
	}
	public void setIdTamanho(Integer idTamanho) {
		this.idTamanho = idTamanho;
	}
	public String getDscTamanho() {
		return dscTamanho;
	}
	public void setDscTamanho(String dscTamanho) {
		this.dscTamanho = dscTamanho;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Tamanho [idTamanho=" + idTamanho + ", dscTamanho=" + dscTamanho + ", sigla=" + sigla + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTamanho == null) ? 0 : idTamanho.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tamanho other = (Tamanho) obj;
		if (idTamanho == null) {
			if (other.idTamanho != null)
				return false;
		} else if (!idTamanho.equals(other.idTamanho))
			return false;
		return true;
	}
	
	
	
	
}
