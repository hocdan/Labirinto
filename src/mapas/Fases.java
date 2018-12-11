package mapas;

//bibliotecas usadas para manipulação de arquivo
import java.io.BufferedReader; //buffer de leitura
import java.io.FileNotFoundException; //para possiveis erros ao procurar arquivos
import java.io.FileReader; //para leitura de arquivos
import java.io.FileWriter; //para gravação de arquivos
import java.io.IOException; //para possiveis exceções na entrad/saida de dados
import java.io.PrintWriter; //para mostrar o conteúdo dos arquivos
import java.io.File; // para manipular arquivos no geral

public class Fases {
	
	//construtor que irá alterar o labirinto atual do jogo lendo a fase de um arquivo
	public Fases(String caminho, String[][] lab, int col) {
		
		//preparando leitura do arquivo com a fase
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String conteudo = "";
			//lendo linha por linha do arquivo
			int linha = 0;
			try {
				conteudo = lerArq.readLine();
				while (conteudo != null) {
					//preenchendo matriz da fase com o conteudo do arquivo
					for ( int i=0; i<col; i++) {
						lab[linha][i] = conteudo.substring(i, i+1); //preenchendo a matriz
					}
					conteudo = lerArq.readLine();
					linha++; // incrementando a linha da matriz
				}
				arq.close();
			//erro na leitura
			} catch ( IOException ex) {
				System.err.println("Erro ao construir fase...");
			}
		}catch ( FileNotFoundException ex) {
			System.err.println("Erro ao ler fase...");
		}
		
	}

}
