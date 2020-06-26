package br.com.treinamento.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Questao1 {

	public final static String nomeArquivo = "listaPalindromo.txt";
	public final static String gravarArquivo = "GravarPalindromo.txt";

	public static void main(String[] args) {
		boolean isPalindromo;
		String linha;
		String palavra = "";

		//Caminho de diretório
		File arquivo = new File(nomeArquivo);

		if (arquivo.exists()) {
			if (arquivo.isFile()) {

				try {
					//Lendo "arquivo.txt"
					BufferedReader in = new BufferedReader(new FileReader(arquivo));
					//Arquivo "gravar.txt"
					PrintWriter gravarArq = new PrintWriter(new FileWriter (gravarArquivo));


					//Lendo linha
					while ((linha = in.readLine()) != null) {
						palavra = ""+palavra+linha;
					}

					//Delimitadores 
					String delimitadores = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\!\\s*|\\?\\s*";

					//Analisando a string
					String[] tokens = palavra.split(delimitadores);

					for (String lista : tokens) {
						String paramReverse = new StringBuilder(lista).reverse().toString();
						isPalindromo = lista.equalsIgnoreCase(paramReverse);

						if (isPalindromo) {
							gravarArq.printf("%s [é palíndromo] \n",lista);
						} else {
							gravarArq.printf("%s [não é palíndromo] \n",lista);
						}
					
					}


					//Fecha arquivo leitura e gravado
					in.close();
					gravarArq.close();

				} catch (IOException e) {
					// TODO Auto-generated
					e.printStackTrace();
				}

			}

		} else {
			System.out.printf("Erro: arquivo ou diretório informado não existe!\n");
		}
	}

}