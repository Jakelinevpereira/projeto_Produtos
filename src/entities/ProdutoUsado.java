package entities;

import java.util.Date;

public class ProdutoUsado extends Produtos {
	private Date dataFabricacao;
	private String etiquetaPreco;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public void setEtiquetaDePreco(String etiquetaDePreco) {
		this.etiquetaPreco = etiquetaDePreco;
	}

	public String getEtiquetaPreco() {
		return this.etiquetaPreco + dataFabricacao;

	}

	@Override
	public String toString() {
		return "ProdutoUsado [dataFabricacao=" + dataFabricacao + ", etiquetaPreco=" + etiquetaPreco + "]";
	}

}
