/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseLexica;

/**
 *
 * @author Ronaldo Gomes
 * @author Alesson Davi
 */
public class Mapeamento {
	/**
	 * 
	 * @param c
	 *            char - um byte numero representado a tabela ascii
	 * @return Coluna - coluna da tabela de transiÃ§Ã£o a qual o caracter c
	 *         pertence ( digito, letra...)
	 */
	public static Coluna mapeiaCaracter(int c) {
		if (c == 69)
			return Coluna.E;
		if (c > 47 && c < 58)
			return Coluna.D;
		if (c > 64 && c < 91 || c > 96 && c < 123)
			return Coluna.L;
		if (c == 32) {
			return Coluna.ESPACO;
		}
		if (c == 10 || c == 13) {
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
		if (c == 95) {
			return Coluna.UNDER_LINE;
		}
		return Coluna.OUTRO;
	}

	/**
	 * 
	 * @param estado
	 *            int -
	 * @param lexema
	 *            String - lexema formado ao reconhecer o token
	 * @return Token - Token reconhecido pelo estado em que o automato parou.
	 */
	public static Token mapeiaEstado(int estado, String lexema,
			TabelaDeSimbolos tabelaDeSimbolos) {
		if (estado == 27) {
			Token.ERRO.lexema = lexema;
			return Token.ERRO;
		}
		if (estado == 1) {
			Token.NUM.tipo = "Inteiro";
			Token.NUM.lexema = lexema.trim();
			return Token.NUM;
		}
		if (estado == 3) {
			Token.NUM.tipo = "Real";
			Token.NUM.lexema = lexema.trim();
			return Token.NUM;
		}
		if (estado == 6) {
			Token.NUM.tipo = "NC";
			Token.NUM.lexema = lexema.trim();
			return Token.NUM;
		}
		if (estado == 7) {
			Token.ID.lexema = lexema.trim();
			return TabelaDeSimbolos.insereNaTabSimbolos(Token.ID,
					tabelaDeSimbolos);
		}
		if (estado == 9) {
			Token.LITERAL.lexema = lexema.trim();
			return Token.LITERAL;
		}
		if (estado == 11) {
			Token.COMENTARIO.lexema = lexema;
			return Token.COMENTARIO;
		}
		if (estado == 17) {
			Token.OPR.lexema = lexema.trim();
			return Token.OPR;
		}
		if (estado == 13) {
			Token.OPR.lexema = lexema;
			return Token.OPR;
		}
		if (estado == 14) {
			Token.OPR.lexema = lexema;
			return Token.OPR;
		}
		if (estado == 15) {
			Token.OPR.lexema = lexema;
			return Token.OPR;
		}
		if (estado == 16) {
			Token.OPR.lexema = lexema;
			return Token.OPR;
		}
		if (estado == 18) {
			Token.OPR.lexema = lexema;
			return Token.RCB;
		}
		if (estado == 19) {
			Token.OPM.lexema = lexema;
			return Token.OPM;
		}
		if (estado == 20) {
			Token.OPM.lexema = lexema;
			return Token.OPM;
		}
		if (estado == 21) {
			Token.OPM.lexema = lexema;
			return Token.OPM;
		}
		if (estado == 22) {
			Token.OPM.lexema = lexema;
			return Token.OPM;
		}
		if (estado == 23) {
			Token.AB_P.lexema = lexema;
			return Token.AB_P;
		}
		if (estado == 24) {
			Token.FC_P.lexema = lexema;
			return Token.FC_P;
		}
		if (estado == 25) {
			Token.PT_V.lexema = lexema;
			return Token.PT_V;
		}
		if (estado == 26) {
			return Token.EOF;
		}
		Token.ERRO.lexema = lexema;
		return Token.ERRO;
	}
}
