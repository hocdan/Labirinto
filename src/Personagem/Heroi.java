package Personagem;

public class Heroi {
	
	//Atributos basicos de todo personagem
	protected int vida;
	protected int defesa;
	protected int ataque;
	protected int alcance = 1;
	
	//Informações básicas de todo personagem
	protected int nivel;
	protected int xp;
	protected String nome;
	protected String classe;
	private int x = 0; //coordenada x inicial do personagem (coluna da matriz)
	private int y = 0; //coordenada y inicial do personagem (linha da matriz)
	
	//vetor de verificação de nivel
	int[] xpPorNivel = new int[30];
	
	//construtor do personagem
	Heroi(String classe, String nome){
		
		//convertendo conteudo para minusculo, evitando diferenças ao escrever
		classe = classe.toLowerCase();
				
		//inicializando nome e classe do jogador
		this.nome = nome;
		this.classe = classe;
		
		//inicializando nivel e xp
		this.nivel = 0;
		this.xp = 0;
		
		//preenchendo vetor de xp necessário por nivel
		for( int i=0; i<this.xpPorNivel.length; i++) {
			this.xpPorNivel[i] = (i+1)*(i+1)*100;
		}
		
		//verificando qual classe foi criada...e inicializando atributos basicos com base nisso
		if ( classe.equals("guerreiro")) {
			this.vida = 8;
			this.defesa = 5;
			this.ataque = 9;
		}
		else if ( classe.equals("guardiao")) {
			this.vida = 7;
			this.defesa = 9;
			this.ataque = 6;
		}
		else if ( classe.equals("ladrao")) {
			this.vida = 6;
			this.defesa = 4;
			this.ataque = 12;
		}
		else if ( classe.equals("arqueiro")){
			this.vida = 7;
			this.defesa = 4;
			this.ataque = 11;
		}
		
	}
	
	//Ações basicas que o personagem pode realizar
	
	public void andar(String[][] labirinto, String movimento) {
		
		//convertendo conteudo para minusculo
		movimento = movimento.toLowerCase();
		
		//checando qual tipo de movimento foi solicitado ( W, A, S, D)
		if ( movimento.equals("w")) {
			
			//se não houver obstaculos acima do personagem...
			if ( labirinto[this.y-1][this.x].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.y -= 1; //diminuo a posição y dele ( andar pra cima )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
			
		}
		else if ( movimento.equals("a")) {
			
			//se não houver obstaculos à esquerda do personagem...
			if ( labirinto[this.y][this.x-1].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.x -= 1; //diminuo a posição x dele ( andar pra esquerda )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
			
		}
		else if ( movimento.equals("s")) {
			
			//se não houver obstaculos abaixo do personagem...
			if ( labirinto[this.y+1][this.x].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.y += 1; //incremento a posição y dele ( andar pra baixo )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
			
		}
		else if ( movimento.equals("d")) {
			
			//se não houver obstaculos à direita do personagem...
			if ( labirinto[this.y][this.x+1].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.x += 1; //incremento a posição x dele ( andar pra direita )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
		}
		
	}
	
	public void verStatus() {
		
		System.out.println("Status do jogador " + this.nome + "\n");
		System.out.println("Nível atual: " + this.nivel);
		System.out.println("Classe escolhida: " + this.classe);
		System.out.println("Vida máxima: " + this.vida);
		System.out.println("Defesa básica: " + this.defesa);
		System.out.println("Ataque básico: " + this.ataque);
		System.out.println();
		
	}
	
	public void setXp(int xpGanho) {
		
		//verificando se jogador alcançou o nível máximo
		if ( this.nivel < 30) { 
			this.xp += xpGanho;
			//verificando se o jogador pode passar de nível de acordo com o vetor de xp
			for( int i=0; i<this.xpPorNivel.length; i++) {
				if ( xp >= xpPorNivel[i] && nivel < (i+1)) {
					this.nivel += 1; //upando um nível caso alcance o xp necessário
					this.xp -= xpPorNivel[i];
				}
			}
		}
	}
	
	public void receberDano(int danoBruto) {
		
		//convertendo o dano recebido ( dano recebido = dano bruto - defesa )
		int danoRecebido = danoBruto - this.defesa;
		//aplicando o dano total
		if ( danoRecebido > 0) this.vida -= danoBruto + danoRecebido;
		else this.vida -= danoBruto;
		
	}
	
	public int ataqueBasico(String[][] labirinto) {
		
		//procurando alvo nas redondezas...
		for( int range=1; range<= this.alcance; range++) {
			//alvo está acima
			if ( labirinto[this.y-range][this.x] == "&" && this.vida > 0) {
				return this.ataque;
			}
			//alvo está abaixo
			else if ( labirinto[this.y+range][this.x] == "&" && this.vida > 0) {
				return this.ataque;
			}
			//alvo está na esquerda
			else if ( labirinto[this.y][this.x-range] == "&" && this.vida > 0) {
				return this.ataque;
			}
			//alvo está na direita
			else if ( labirinto[this.y][this.x+range] == "&" && this.vida > 0) {
				return this.ataque;
			}
		}
		//se não achou alvo em todas as direções possíveis dentro do seu alcance, então...
		return 0;
		
	}

}
