/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise;
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
			System.out.println("TOKEN = ["+token+"]: LEXEMA ["+token.lexema+ "]");
		}while(token != token.EOF);
               
		

	}
    
}
