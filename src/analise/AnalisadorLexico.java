package analise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AnalisadorLexico {
	 static long ponteiroArquivo=0;
	 static int c=0;
	 static String lexema;
         static int contLinha=1;
	static RandomAccessFile arquivo=null;
        /**
         * analisaLexema() - Lê byte por byte do arquivo enqunto monta os lexemas e define os tokens ao qual pertencem. 
         * @param path String - caminho do arquivo de entrada
         * @return Token - token encontrado no arquivo
         */
	public static Token analisaLexema(String path) {	
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
                        //tratar o laço infinito quando o erro é o ultimo token do arquivo
                        if(Tabelas.tabelaDeTransicao[estado][Mapeamento.mapeiaCaracter(c).valor] == -2){
                            lexema+=(char)c;
                            c=arquivo.read();
                        
                        }
                        
                        try{
			while(Tabelas.tabelaDeTransicao[estado][Mapeamento.mapeiaCaracter(c).valor] != -2){
                            estado = Tabelas.tabelaDeTransicao[estado][Mapeamento.mapeiaCaracter(c).valor];
                            if(c!=-1 || c== 13/**&& c!=32 && c != 10 && c!=9 && c!=13*/)
                                lexema+=(char)c;
                            c=arquivo.read(); 
                            if(c==10)
                                AnalisadorLexico.contLinha++;
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
                //System.out.println(estado);
                return Mapeamento.mapeiaEstado(estado, lexema);
	}
}
