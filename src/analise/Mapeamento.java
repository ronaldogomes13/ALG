/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise;

import java.io.IOException;

/**
 *
 * @author Ronaldo Gomes
 * @author Álesson Davi
 */
public class Mapeamento {
    public static int contLinha=0;
     TabelaDeSimbolos tab = new TabelaDeSimbolos();
    /**
     * 
     * @param c char - um byte numero representado a tabela ascii
     * @return Coluna - coluna da tabela de transição a qual o caracter c pertence ( digito, letra...)
     */
    public static Coluna mapeiaCaracter(int c)  {
		if (c == 69)
			return Coluna.E;
		if (c > 47 && c < 58)
			return Coluna.D;
		if (c > 64 && c < 91 || c > 96 && c < 123)
			return Coluna.L;
		if (c == 32){
			return Coluna.ESPACO;
                }
		if (c == 10 || c==13){
                    if(c==13)
                    AnalisadorLexico.contLinha++;
                    return Coluna.BARRA_N;
                }
		if (c == 9)
			return Coluna.BARRA_T;
		if (c == 59)
			return Coluna.PT_V;
		if (c == 40)
			return Coluna.AB_P;
		if (c == 41)
			return Coluna.FC_P;
		if (c == 123)
			return Coluna.AB_CHAVE;
		if (c == 125)
			return Coluna.FC_CHAVE;
		if (c == 34)
			return Coluna.ASPAS;
		if (c == 61)
			return Coluna.IGUAL;
		if (c == -1)
			return Coluna.EOF;
		if (c == 47)
			return Coluna.BARRA;
		if (c == 42)
			return Coluna.VEZES;
		if (c == 43)
			return Coluna.MAIS;
		if (c == 45)
			return Coluna.MENOS;
		if (c == 62)
			return Coluna.MAIOR;
		if (c == 60)
			return Coluna.MENOR;
		if (c == 46)
			return Coluna.PONTO;
		if (c == 95){
			return Coluna.UNDER_LINE;
                }
		return Coluna.OUTRO;
	}
    /**
     * 
     * @param estado  int - 
     * @param lexema String - lexema formado ao reconhecer o token
     * @return Token - Token reconhecido pelo estado em que o automato parou.
     */
    public static Token mapeiaEstado(int estado, String lexema) {
		if(estado==27){
                    Token.ERRO.lexema=lexema;
			return Token.ERRO;
                }   
		if(estado == 1){
                         // Num ( inteiro) estado final
                        // while(!isConcatenavelNum(AnalisadorLexico.c))
                        Token.NUM.tipo="Inteiro";
			Token.NUM.lexema=lexema;
			return Token.NUM;
                }
		if(estado==3){ // Num (real) estado final 28
                        Token.NUM.tipo="Real";
			Token.NUM.lexema=lexema;
			return Token.NUM;
                }
		if(estado==6){// Num (com notação cientifica real ou inteiro) estado final 29
                        Token.NUM.tipo="NC";
			Token.NUM.lexema=lexema;
			return Token.NUM;
                }
		if(estado==7){  // id estado final 31
			Token.ID.lexema=lexema;
                        //return Token.ID;
                        TabelaDeSimbolos tab = new TabelaDeSimbolos();
                        return tab.palavrasReservadas(Token.ID);
                }
		if(estado==9){ // Literal
			Token.LITERAL.lexema=lexema;
			return Token.LITERAL;
                }
		if(estado==11){ // Comentário
			Token.COMENTARIO.lexema=lexema;
			return Token.COMENTARIO;
                }
		if(estado==17) {// Operador relacional – OPR 
			Token.OPR.lexema=lexema;
			return Token.OPR;
                }
                if(estado==13) {// Operador relacional – OPR >
			Token.OPR.lexema=lexema;
			return Token.OPR;
                }
                 if(estado==15){ // Operador relacional – OPR <=
			Token.OPR.lexema=lexema;
			return Token.OPR;
                 }
                 if(estado==16){ // Operador relacional – OPR <>
			Token.OPR.lexema=lexema;
			return Token.OPR;
                 }
		if(estado==18) {// Atribuição – RCB (<-)
			Token.OPR.lexema=lexema;
			return Token.RCB;
                }
		if(estado==19){// Operadores aritméticos – OPM (+)
			Token.OPM.lexema=lexema;
			return Token.OPM;
                }
		if(estado==20){ // Operadores aritméticos – OPM (-)
			Token.OPM.lexema=lexema;
			return Token.OPM;
                }
		if(estado==21){ // Operadores aritméticos – OPM (*)
			Token.OPM.lexema=lexema;
			return Token.OPM;
                }
		if(estado==22){ // Operadores aritméticos – OPM (/)
			Token.OPM.lexema=lexema;
			return Token.OPM;
                }
		if(estado==23){ // Abre Parentes – AB_P (
			Token.AB_P.lexema=lexema;
			return Token.AB_P;
                }
		if(estado==24){ // Fecha Parentes – FC_P )
			Token.FC_P.lexema=lexema;
			return Token.FC_P;
                }
		if(estado==25) {// Ponto e Virgula – PT_V (;)
			Token.PT_V.lexema=lexema;
			return Token.PT_V;
                }
		if(estado==26){ // Fim de Arquivo - EOF
			return Token.EOF;
                }   //System.out.println(" estado "+estado);
                        
                Token.ERRO.lexema=lexema;
		return Token.ERRO;
		}
}
