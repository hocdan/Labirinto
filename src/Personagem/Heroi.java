package Personagem;

public class Heroi {
	
	//Atributos basicos de todo personagem
	protected int vida;
	protected int defesa;
	protected int ataque;
	protected int alcance = 1;
	
	//Informa��es b�sicas de todo personagem
	protected int nivel;
	protected int xp;
	protected String nome;
	protected String classe;
	private int x = 0; //coordenada x inicial do personagem (coluna da matriz)
	private int y = 0; //coordenada y inicial do personagem (linha da matriz)
	
	//vetor de verifica��o de nivel
	int[] xpPorNivel = new int[30];
	
	//construtor do personagem
	Heroi(String classe, String nome){
		
		//convertendo conteudo para minusculo, evitando diferen�as ao escrever
		classe = classe.toLowerCase();
				
		//inicializando nome e classe do jogador
		this.nome = nome;
		this.classe = classe;
		
		//inicializando nivel e xp
		this.nivel = 0;
		this.xp = 0;
		
		//preenchendo vetor de xp necess�rio por nivel
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
	
	//A��es basicas que o personagem pode realizar
	
	public void andar(String[][] labirinto, String movimento) {
		
		//convertendo conteudo para minusculo
		movimento = movimento.toLowerCase();
		
		//checando qual tipo de movimento foi solicitado ( W, A, S, D)
		if ( movimento.equals("w")) {
			
			//se n�o houver obstaculos acima do personagem...
			if ( labirinto[this.y-1][this.x].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.y -= 1; //diminuo a posi��o y dele ( andar pra cima )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
			
		}
		else if ( movimento.equals("a")) {
			
			//se n�o houver obstaculos � esquerda do personagem...
			if ( labirinto[this.y][this.x-1].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.x -= 1; //diminuo a posi��o x dele ( andar pra esquerda )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
			
		}
		else if ( movimento.equals("s")) {
			
			//se n�o houver obstaculos abaixo do personagem...
			if ( labirinto[this.y+1][this.x].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.y += 1; //incremento a posi��o y dele ( andar pra baixo )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
			
		}
		else if ( movimento.equals("d")) {
			
			//se n�o houver obstaculos � direita do personagem...
			if ( labirinto[this.y][this.x+1].equals("0")) {
				
				//limpo o local em que o personagem estava anteriormente...
				labirinto[this.y][this.x] = "0";
				
				this.x += 1; //incremento a posi��o x dele ( andar pra direita )
				
				//atualizo o valor na matriz com as novas coordenadas
				labirinto[this.y][this.x] = "&";
			}
		}
		
	}
	
	public void verStatus() {
		
		System.out.println("Status do jogador " + this.nome + "\n");
		System.out.println("N�vel atual: " + this.nivel);
		System.out.println("Classe escolhida: " + this.classe);
		System.out.println("Vida m�xima: " + this.vida);
		System.out.println("Defesa b�sica: " + this.defesa);
		System.out.println("Ataque b�sico: " + this.ataque);
		System.out.println();
		
	}
	
	public void setXp(int xpGanho) {
		
		//verificando se jogador alcan�ou o n�vel m�ximo
		if ( this.nivel < 30) { 
			this.xp += xpGanho;
			//verificando se o jogador pode passar de n�vel de acordo com o vetor de xp
			for( int i=0; i<this.xpPorNivel.length; i++) {
				if ( xp >= xpPorNivel[i] && nivel < (i+1)) {
					this.nivel += 1; //upando um n�vel caso alcance o xp necess�rio
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
			//alvo est� acima
			if ( labirinto[this.y-range][this.x] == "&" && this.vida > 0) {
				return this.ataque;
			}
			//alvo est� abaixo
			else if ( labirinto[this.y+range][this.x] == "&" && this.vida > 0) {
				return this.ataque;
			}
			//alvo est� na esquerda
			else if ( labirinto[this.y][this.x-range] == "&" && this.vida > 0) {
				return this.ataque;
			}
			//alvo est� na direita
			else if ( labirinto[this.y][this.x+range] == "&" && this.vida > 0) {
				return this.ataque;
			}
		}
		//se n�o achou alvo em todas as dire��es poss�veis dentro do seu alcance, ent�o...
		return 0;
		
	}

}
