/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise;

import java.util.Hashtable;

/**
 *
 * @author Ronaldo Gomes
 */
public class MainTeste {
    public static void main(String args[]) {
         String path = "src/analise/Teste.txt";
	AnalisadorLexico an = new AnalisadorLexico();
	Token token;       
	do{
            token = an.analisaLexema(path);
            if(token!=Token.ERRO){
            System.out.println(AnalisadorLexico.contLinha+". TOKEN = ["+token+"]: LEXEMA ["+token.lexema.trim()+ "]");
            }else{
                System.err.println(AnalisadorLexico.contLinha+". TOKEN = ["+token+"]: LEXEMA ["+token.lexema.trim()+ "]");
            }
		}while(token != token.EOF); 
                
	}
    
}
