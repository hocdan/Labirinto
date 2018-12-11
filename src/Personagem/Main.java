package Personagem;

import mapas.Fases;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//matriz do labirinto
		int lin = 8;
		int col = 10;
		String[][] labirinto = new String[lin][col];
		
		//criando novo caminho para carregar a fase3
		String caminho = "C:\\Users\\Danie\\OneDrive\\Documentos\\2018.2\\Paradigmas de Programação\\exercicios\\Area de trabalho\\Labirinto\\mapas\\fase3.txt";
		Fases fase3 = new Fases(caminho, labirinto, col);
				
		//mostrando labirinto
		System.out.println("Labirinto atual:");
		for( int i=0; i<lin; i++) {
			for( int j=0; j<col; j++) {
				System.out.print(labirinto[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//criando um jogador da classe ladrão com o nome de Hacdan e fazendo-o receber xp
		Heroi jogador = new Heroi("ladrao", "Hacdan");
		jogador.verStatus();
		jogador.setXp(1400);
		jogador.verStatus();
		jogador.setXp(1500);
		jogador.verStatus();
		jogador.setXp(100);
		jogador.verStatus();
		
		//verificando ações
		while (true) {
			System.out.print("( 1- Andar / 2- Mostrar labirinto / 3- Sair ): ");
			int acao = in.nextInt();
			
			if ( acao == 1) {
				System.out.print("Movimento(WASD): ");
				String mov = in.next();
				jogador.andar(labirinto, mov);
			}
			else if ( acao == 2) {
				//mostrando labirinto
				System.out.println("Labirinto atual:");
				for( int i=0; i<lin; i++) {
					for( int j=0; j<col; j++) {
						System.out.print(labirinto[i][j] + " ");
					}
					System.out.println();
				}
			}
			else if ( acao == 3) {
				System.out.println("Encerrando aplicação...");
				break;
			}
			
		}
		
		
	}

}
