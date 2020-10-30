package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ProdutoImportado;
import entities.ProdutoUsado;
import entities.Produtos;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Produtos> list = new ArrayList<Produtos>();

		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print("Produto #" + i + " data:");
			System.out.print("Qual o tipo do produto(c,u,i)? ");// (comum,usado,importado)
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.printf("Preço: ");
			double preco = sc.nextDouble();
			if (ch == 'c') {
				Produtos prod = new Produtos(nome, preco);
				list.add(prod);
			} else if (ch == 'u') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
				String data = sc.next();
				Date dataDeFabricacao = sdf1.parse(data);
				ProdutoUsado prodU = new ProdutoUsado(nome, preco, dataDeFabricacao);
				list.add(prodU);
			} else {
				System.out.print("Valor da Taxa da Alfândega: ");
				double taxaAlfandega = sc.nextDouble();
				ProdutoImportado prodI = new ProdutoImportado(nome, preco + taxaAlfandega, taxaAlfandega);
				list.add(prodI);
			}
		}

		System.out.println("----------------------------");
		System.out.println("Etiqueta de preço: ");
		for (Produtos prod : list) {

			{
				if(prod instanceof ProdutoUsado) {
					ProdutoUsado prodU = (ProdutoUsado) prod;
					System.out.println(prod.getNome() + " $ " + String.format("%.2f", prod.getPreco(), prodU.getDataFabricacao()));
				} else if (prod instanceof ProdutoImportado){
					ProdutoImportado prodI = (ProdutoImportado) prod;
					System.out.println(prod.getNome() + " $ " + String.format("%.2f", prod.getPreco(), + ((ProdutoImportado) prod).getTaxaAlfandega()));
				} else {
					System.out.println(prod.getNome() + " $ " + String.format("%.2f", prod.getPreco()));
				}
			}
		}
	}

}
