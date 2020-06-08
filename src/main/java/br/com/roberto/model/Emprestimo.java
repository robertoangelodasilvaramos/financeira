package br.com.roberto.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable{

	
	
	
	private static final long serialVersionUID = 8112493179106282556L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String Nome;

	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private int parcelas;
	
	@Column(name = "data_financiamento",nullable = false)
	private String dataFinanciamento;
	
	@Column(name = "data_termino_financiamento",nullable = false)
	private String DataTerminoFinanciamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public String getDataFinanciamento() {
		return dataFinanciamento;
	}

	public void setDataFinanciamento(String dataFinanciamento) {
		this.dataFinanciamento = dataFinanciamento;
	}

	public String getDataTerminoFinanciamento() {
		return DataTerminoFinanciamento;
	}

	public void setDataTerminoFinanciamento(String dataTerminoFinanciamento) {
		DataTerminoFinanciamento = dataTerminoFinanciamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DataTerminoFinanciamento == null) ? 0 : DataTerminoFinanciamento.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((dataFinanciamento == null) ? 0 : dataFinanciamento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + parcelas;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (DataTerminoFinanciamento == null) {
			if (other.DataTerminoFinanciamento != null)
				return false;
		} else if (!DataTerminoFinanciamento.equals(other.DataTerminoFinanciamento))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (dataFinanciamento == null) {
			if (other.dataFinanciamento != null)
				return false;
		} else if (!dataFinanciamento.equals(other.dataFinanciamento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parcelas != other.parcelas)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", Nome=" + Nome + ", descricao=" + descricao + ", valor=" + valor
				+ ", parcelas=" + parcelas + ", dataFinanciamento=" + dataFinanciamento + ", DataTerminoFinanciamento="
				+ DataTerminoFinanciamento + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
