package analise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AnalisadorLexico {
	 static long ponteiroArquivo=0;
	 static int c=0;
	 static String lexema;
	static RandomAccessFile arquivo=null;
	static int tabelaDeTransicao[][] =
                 //     0       1       2       3       4       5       6       7       8       9       10      11      12      13      14      15      16      17      18      19      20      21      22  
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
		{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2	},//9
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
                {	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,     -2,	-2	},//34
		};
        /**
         * analisaLexema() - Lê byte por byte do arquivo enqunto monta os lexemas e define os tokens ao qual pertencem. 
         * @param path String - caminho do arquivo de entrada
         * @return Token - token encontrado no arquivo
         */
	public Token analisaLexema(String path) {	
		 int estado=0;
		 lexema=""; 
		 try {
			arquivo=new RandomAccessFile(new File(path), "r");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Não encontrado");
		}
		try {
			arquivo.seek(ponteiroArquivo);
			c = arquivo.read();
                        
                        try{
			while(tabelaDeTransicao[estado][Mapeamento.mapeiaCaracter(c).valor] != -2){
				estado = tabelaDeTransicao[estado][Mapeamento.mapeiaCaracter(c).valor];
                                if(c!=-1)
                                    lexema+=(char)c;
				c=arquivo.read(); 
				ponteiroArquivo++;
                                if(estado<0)
                                    break;
			}
                        }catch(ArrayIndexOutOfBoundsException err){
                            System.out.println("Consulta na matriz com estes parametros é impossivel [ "+estado+" ] [ "+Mapeamento.mapeiaCaracter(c).valor+" ]");
                        }
                        
		} catch (IOException e) {
			System.out.println("ERRO NA LEITURA DO ARQUIVO");
		}                
		return Mapeamento.mapeiaEstado(estado, lexema);
	}
}
