/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseSintatica;

import analiseLexica.AnalisadorLexico;
import analiseLexica.OperaTabelaDeSimbolos;
import analiseLexica.TabelaDeSimbolos;
import analiseLexica.Token;

/**
 *
 * @author Ronaldo Gomes
 */
public class Main {
    public static void main(String args[]){
        TabelaDeSimbolos tabelaDeSimbolos = new TabelaDeSimbolos();
        //OperaTabelaDeSimbolos.imprimeTabDeSimbolos(tabelaDeSimbolos);
        AnalisadorSintatico analisador = new AnalisadorSintatico();
        analisador.analisaSintaxe(tabelaDeSimbolos);
        //OperaTabelaDeSimbolos.imprimeTabDeSimbolos(tabelaDeSimbolos);
        
        /**apenas para testes
          String path = "src/analiseLexica/Teste.txt";
	AnalisadorLexico an = new AnalisadorLexico();
	Token token;    
       do{
           token=an.analisaLexema(path,tabelaDeSimbolos);
           System.out.println("Token: ["+token+"]; Lexema: ["+token.lexema+"];  Tipo: "+token.tipo);
            
        }while(token!=token.EOF);
        OperaTabelaDeSimbolos.imprimeTabDeSimbolos(tabelaDeSimbolos);
        *///fim dos testes
        
        for(int i=0;i<analisador.gramatica.length;i++){
            System.out.println((i+1)+" "+analisador.gramatica[i]);
        }
    }
    
}
