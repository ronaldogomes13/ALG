package analise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AnalisadorLexico {
	public static String path = "src/analise/Teste.txt";
	 static long ponteiroArquivo=0;
	 static int estado=0;
	 static int c=0;
	 String lexema;
	static RandomAccessFile arquivo=null;
	static int tabelaDeTransicao[][] =
		// 	L	D	{	}	"	<	>	=	-	+	*	/	(	)	;	EOF	E	pt	out	sp	\n	\t	underL	
		{{	7,	1,	10,	-2,	8,	12,	13,	17,	20,	19,	21,	22,	23,	24,	25,	26,	-2,	-2,	-2,	0,	0,	0,	-2	},//0
		{	-2,	1,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	4,	2,	27,	27,	27,	27,	-2	},//1 
		{	-2,	3,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//2
		{	-2,	3,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	28,	4,	-2,	28,	28,	28,	28,	-2	},//3 
		{	-2,	6,	-2,	-2,	-2,	-2,	-2,	-2,	5,	5,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//4
		{	-2,	6,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//5
		{	-2,	6,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	29,	-2,	-2,	29,	29,	29,	29,	-2	},//6 
		{	7,	7,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	31,	-2,	-2,	31,	31,	31,	31,	7	},//7
		{	8,	8,	8,	8,	9,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8	},//8
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	2,	-2,	-2,	-2	},//9
		{	10,	10,	10,	11,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10	},//10
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//11
		{	-2,	-2,	-2,	-2,	-2,	-2,	16,	15,	18,	-2,	-2,	-2,	-2,	-2,	-2,	33,	-2,	-2,	33,	33,	33,	33,	-2	},//12 
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	14,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	32,	32,	3,	32,	-2	},//13 
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	30,	-2,	-2,	30,	30,	30,	30,	-2	},//14 
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	30,	-2,	-2,	30,	30,	30,	30,	-2	},//15 
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	30,	-2,	-2,	30,	30,	30,	30,	-2	},//16 
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	30,	-2,	-2,	30,	30,	30,	30,	-2	},//17 
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	18,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//18 
		{	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//19 
		{	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//20 
		{	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//21 
		{	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//22 
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//23
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//24
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//25
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//26
		{	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//27
		{	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//28
		{	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//29
		{	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//30
		{	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//31
                {	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//32
                {	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//33
		};
        /**
         * 
         * @param path String - caminho do arquivo de entrada
         * @return Token - token encontrado no arquivo
         */
	public Token lexico(String path) {	
		 estado=0;
		 lexema=""; // contem o lexema no retorno do token
		 try {
			arquivo=new RandomAccessFile(new File(path), "r");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Não encontrado");
		}
		try {
			arquivo.seek(ponteiroArquivo);// fixa o inicio do arquivo a partir de um ponto especificado por ponteiroArquivo
			c = arquivo.read();//inicia a leitura do  arquivo - tabela ASCII
                        System.out.println(c);
                        //roda o arquivo montando os tokens até que chega em um estado de erro (-2)
			while(tabelaDeTransicao[estado][mapaCaracter(c).valor] != -2){
                                //pega o valor do estado após a transião por um simbolo e coloca em estado
				estado = tabelaDeTransicao[estado][mapaCaracter(c).valor];
				lexema+=(char)c;//monta o lexema do token que está sendo montado
				c=arquivo.read(); // Lê o proximo byte do arquivo 
				ponteiroArquivo++; // atualiza o ponto onde onde o arquivo está sendo lido
				if(c==-1){//fim de arquivo (-1)
					return mapaDeEstado(estado);
				}
			}
		} catch (IOException e) {
			System.out.println("ERRO NA LEITURA DO ARQUIVO");
		}
		return mapaDeEstado(estado);
	}
/* Mapea os estados */
	public Token mapaDeEstado(int estado) {
		
		switch (estado) {
		case 27:// Num ( inteiro) estado final 27
                        Token.NUM.tipo="Inteiro";
			Token.NUM.lexema=lexema;
			return Token.NUM;
		case 28: // Num (real) estado final 28
                        Token.NUM.tipo="Real";
			Token.NUM.lexema=lexema;
			return Token.NUM;
		case 29:// Num (com notação cientifica real ou inteiro) estado final 29
                        Token.NUM.tipo="NC";
			Token.NUM.lexema=lexema;
			return Token.NUM;
		case 31:  // id estado final 31
			Token.ID.lexema=lexema;
			return Token.ID;
		case 9: // Literal
			Token.LITERAL.lexema=lexema;
			return Token.LITERAL;
		case 11: // Comentário
			Token.COMENTARIO.lexema=lexema;
			return Token.COMENTARIO;
		case 30: // Operador relacional – OPR 
			Token.OPR.lexema=lexema;
			return Token.OPR;
                case 32: // Operador relacional – OPR >
			Token.OPR.lexema=lexema;
			return Token.OPR;
                  case 15: // Operador relacional – OPR <=
			Token.OPR.lexema=lexema;
			return Token.OPR;
                 case 16: // Operador relacional – OPR <>
			Token.OPR.lexema=lexema;
			return Token.OPR;
		case 18: // Atribuição – RCB (<-)
			Token.OPR.lexema=lexema;
			return Token.RCB;
		case 19: // Operadores aritméticos – OPM (+)
			Token.OPM.lexema=lexema;
			return Token.OPM;
		case 20: // Operadores aritméticos – OPM (-)
			Token.OPM.lexema=lexema;
			return Token.OPM;
		case 21: // Operadores aritméticos – OPM (*)
			Token.OPM.lexema=lexema;
			return Token.OPM;
		case 22: // Operadores aritméticos – OPM (/)
			Token.OPM.lexema=lexema;
			return Token.OPM;
		case 23: // Abre Parentes – AB_P (
			Token.AB_P.lexema=lexema;
			return Token.AB_P;
		case 24: // Fecha Parentes – FC_P )
			Token.FC_P.lexema=lexema;
			return Token.FC_P;
		case 25: // Ponto e Virgula – PT_V (;)
			Token.PT_V.lexema=lexema;
			return Token.PT_V;
		case 26: // Fim de Arquivo - EOF
			return Token.EOF;
		default:
			return Token.ERRO;
		}
	}
        /**
         * 
         * @param c int - da tabela ascii referente ao caracter lido do arquivo
         * @return - tipo de caracter foi lido 
         */
	public static Coluna mapaCaracter(int c)  {
		if (c == 69)
			return Coluna.E;
		if (c > 47 && c < 58)
			return Coluna.D;
		if (c > 64 && c < 91 || c > 96 && c < 123)
			return Coluna.L;
		if (c == 32){
			return Coluna.ESPACO;
		}
		if (c == 10)
			return Coluna.BARRA_N;
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
		if (c == 95)
			return Coluna.UNDER_LINE;
		return Coluna.OUTRO;
	}
	/*Metodo Principal **/
	public static void main(String args[]) {
		AnalisadorLexico an = new AnalisadorLexico();
		Token token;
		do{
			 token = an.lexico(path);
			System.out.println("TOKEN = ["+token+"]: LEXEMA ["+token.lexema+ "]");
		}while(token != token.EOF);
		

	}
}
