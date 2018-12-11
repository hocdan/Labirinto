package mapas;
public class Main {
	
	public static void main(String[] args) {
		String[][] labirinto = new String[5][5];
		
		//mostrando labirinto
		for( int i=0; i<5; i++) {
			for( int j=0; j<5; j++) {
				System.out.print(labirinto[i][j] + " ");
			}
			System.out.println();
		}
		
		//criando fase1
		String caminho = "C:\\Users\\Danie\\OneDrive\\Documentos\\2018.2\\Paradigmas de Programação\\exercicios\\Area de trabalho\\Labirinto\\mapas\\fase1.txt";
		Fases fase1 = new Fases(caminho, labirinto, 5);
		
		//mostrando labirinto
		for( int i=0; i<5; i++) {
			for( int j=0; j<5; j++) {
				System.out.print(labirinto[i][j] + " ");
			}
			System.out.println();
		}
		
		//criando novo caminho para carregar a fase2
		String caminho2 = "C:\\Users\\Danie\\OneDrive\\Documentos\\2018.2\\Paradigmas de Programação\\exercicios\\Area de trabalho\\Labirinto\\mapas\\fase2.txt";
		Fases fase2 = new Fases(caminho2, labirinto, 5);
		
		//mostrando labirinto
		for( int i=0; i<5; i++) {
			for( int j=0; j<5; j++) {
				System.out.print(labirinto[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
