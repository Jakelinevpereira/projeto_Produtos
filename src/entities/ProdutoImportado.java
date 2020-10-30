package entities;

public class ProdutoImportado extends Produtos {
	private Double precoTotal;
	private Double taxaAlfandega;

	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	public void setEtiquetaDePreco(String etiquetaDePreco) {
		this.setEtiquetaDePreco(etiquetaDePreco);
	}

	public double precoTotal() {
		return precoTotal + taxaAlfandega;

	}

	@Override
	public String toString() {
		return "ProdutoImportado [precoTotal=" + precoTotal + ", taxaAlfandega=" + taxaAlfandega + "]";
	}

}
