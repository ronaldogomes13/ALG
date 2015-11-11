package analise;

public enum Token {
    //Tirar o token erro desta enum pois ele tem informações diferentes a serem guadadas
	NUM(1), LITERAL(2),ID(3),COMENTARIO(4), EOF(5),OPR(6),RCB(7),OPM(8),AB_P(9),FC_P(10),PT_V(11),ERRO(12);
	int valor=0;
	String tipo;
	String lexema;
	Token(int valor){
		this.valor=valor;
		
	}
	
}
