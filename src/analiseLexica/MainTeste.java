/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseLexica;

import analiseSintatica.AnalisadorSintatico;
import analiseSintatica.TabelaSintatica;
import java.util.Hashtable;

/**
 *
 * @author Ronaldo Gomes
 */
public class MainTeste {
    public static void main(String args[]) {
         String path = "src/analiseLexica/Teste.txt";
	AnalisadorLexico an = new AnalisadorLexico();
        AnalisadorSintatico analisador = new AnalisadorSintatico();
	Token token;    
       do{
           token=an.analisaLexema(path);
           System.out.println("Token: ["+token+"]; Lexema: ["+token.lexema+"];  Tipo: "+token.tipo);
            
        }while(token!=token.EOF);
       
        //analisador.analisaSintaxe();
      
        
        
        
        
        
    }
    
}