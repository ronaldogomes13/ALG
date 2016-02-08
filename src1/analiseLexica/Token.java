package analiseLexica;

public enum Token {
    //Tirar o token erro desta enum pois ele tem informações diferentes a serem guadadas
	NUM, LITERAL, ID, COMENTARIO, EOF, OPR, RCB, OPM, AB_P, FC_P, PT_V, ERRO,
            INICIO,VARINICIO,VARFIM, ESCREVA , LEIA, SE, ENTAO, FIMSE, FIM,LIT,INTEIRO,REAL;
	public String tipo="";
	public String lexema="";      
}
