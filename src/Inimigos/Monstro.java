package Inimigos;

public class Monstro {
	
	//atributos básicos de todo monstro
	protected int vida;
	protected int defesa;
	protected int ataque;
	protected int alcance;
	protected int xp;
	
	//informações básicas de todo monstro
	private int x;
	private int y;
	
	//construtor basico de todo monstro
	Monstro(String tipo, int fase, int posX, int posY){
		
		//Convertendo string para minusculo
		tipo = tipo.toLowerCase();
		
		//inicializando posições iniciais do monstro
		this.x = posX;
		this.y = posY;
		
		//inicializando atributos básicos por tipo de monstro
		if ( tipo.equals("goblin")) {
			this.vida = 5 * fase;
			this.defesa = 1 * fase;
			this.ataque = 2 * fase;
			this.alcance = 1;
			this.xp = 2 * fase;
		}
		else if ( tipo.equals("esqueleto")) {
			this.vida = 6 * fase;
			this.defesa = 2 * fase;
			this.ataque = 3 * fase;
			this.alcance = 2;
			this.xp = 3 * fase;
		}
		else if ( tipo.equals("demonio")) {
			this.vida = 6 * fase;
			this.defesa = 3 * fase;
			this.ataque = 4 * fase;
			this.alcance = 3;
			this.xp = 5 * fase;
			
		}
		else if ( tipo.equals("zumbi")) {
			this.vida = 8 * fase;
			this.defesa = 2 * fase;
			this.ataque = 3 * fase;
			this.alcance = 1;
			this.xp = 4 * fase;
			
		}
		else if ( tipo.equals("troll")) {
			this.vida = 10 * fase;
			this.defesa = 5 * fase;
			this.ataque = 5 * fase;
			this.alcance = 2;
			this.xp = 10 * fase;
			
		}
		else if ( tipo.equals("ciclope")) {
			this.vida = 12 * fase;
			this.defesa = 4 * fase;
			this.ataque = 6 * fase;
			this.alcance = 1;
			this.xp = 10 * fase;
			
		}
		else if ( tipo.equals("quimera")) {
			this.vida = 10 * fase;
			this.defesa = 5 * fase;
			this.ataque = 8 * fase;
			this.alcance = 2;
			this.xp = 12 * fase;
			
		}
		else if ( tipo.equals("arquibesta")) {
			this.vida = 14 * fase;
			this.defesa = 6 * fase;
			this.ataque = 10 * fase;
			this.alcance = 3;
			this.xp = 15 * fase;
			
		}
		else if(tipo.equals("sucubo")) {
			this.vida = 8 * fase;
			this.defesa = 4 * fase;
			this.ataque = 9 * fase;
			this.alcance = 3;
			this.xp = 30 * fase;
		}
		else if ( tipo.equals("harpia")) {
			this.vida = 6 * fase;
			this.defesa = 3 * fase;
			this.ataque = 5 * fase;
			this.alcance = 3;
			this.xp = 5 * fase;
			
		}
		else if (tipo.equals("sereia")) {
			this.vida = 5 * fase;
			this.defesa = 3 * fase;
			this.ataque = 10 * fase;
			this.alcance = 10;
			this.xp = 40 * fase;
		}
		else if (tipo.equals("empusa")) {
			this.vida = 10 * fase;
			this.defesa = 5 * fase;
			this.ataque = 8 * fase;
			this.alcance = 4;
			this.xp = 50 * fase;
		}
		else if ( tipo.equals("minotauro")) {
			this.vida = 20 * fase;
			this.defesa = 10 * fase;
			this.ataque = 15 * fase;
			this.alcance = 5;
			this.xp = 100 * fase;
		}
		else if ( tipo.equals("hidra")) {
			this.vida = 60 * fase;
			this.defesa = 40 * fase;
			this.ataque = 45 * fase;
			this.alcance = 5;
			this.xp = 400 * fase;
		}
		else if ( tipo.equals("medusa")) {
			this.vida = 40 * fase;
			this.defesa = 30 * fase;
			this.ataque = 60 * fase;
			this.alcance = 5;
			this.xp = 1000 * fase;
		}
		else if ( tipo.equals("cerberus")) {
			this.vida = 80 * fase;
			this.defesa = 50 * fase;
			this.ataque = 70 * fase;
			this.alcance = 5;
			this.xp = 2000 * fase;
		}
		else if ( tipo.equals("titã")) {
			this.vida = 100 * fase;
			this.defesa = 80 * fase;
			this.ataque = 80 * fase;
			this.alcance = 10;
			this.xp = 6000 * fase;
		}
		else if ( tipo.equals("criador")) {
			this.vida = 200 * fase;
			this.defesa = 200 * fase;
			this.ataque = 200 * fase;
			this.alcance = 20;
			this.xp = 10000 * fase;
		}
		
	}
	
	//ações que todo monstro é capaz de fazer
	public int atacar(String[][] labirinto) {
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
		//se não achou alvo em todas as direções possíveis dentro da sua range, então...
		return 0;
	}

}
