package br.com.treinamento.main;

import java.io.*;


public class Questao2 {

	public final static String nomeArquivo = "arquivo.txt";
	public final static String gravarArquivo = "gravar.txt";

	public static void main(String[] args) {
		
		String linha;

		File arquivo = new File(nomeArquivo);

		if (arquivo.exists()) {
			
			if (arquivo.isFile()) {
				
				System.out.printf("Arquivo (%s) existe - tamanho: %d bytes\n", arquivo.getName(), arquivo.length());
				
				try {
					//Lendo "arquivo.txt"
					BufferedReader in = new BufferedReader(new FileReader(arquivo));
					//Arquivo "gravar.txt"
					PrintWriter gravarArq = new PrintWriter(new FileWriter (gravarArquivo));
					
					StringBuilder frase = new StringBuilder();

					//Lendo linha
					while ((linha = in.readLine()) != null) {
						
						frase = frase.append(linha);
						
					}
					
					
					String texto = new String(frase);
					//Arquivado gravando gravar.txt
					gravarArq.print(texto.replaceAll("\\.", "| \n"));
				
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
