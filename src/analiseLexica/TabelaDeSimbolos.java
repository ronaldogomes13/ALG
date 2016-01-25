/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseLexica;

import static analiseLexica.Token.*;
import java.util.Hashtable;

/**
 *
 * @author Ronaldo Gomes
 */
class TabelaDeSimbolos {
    Hashtable<String, Token> tabela = new Hashtable<>();    

    public TabelaDeSimbolos() {
        /** INICIA A TABELA DE SIMBOLOS COM AS PALAVRAS RESERVADAS   */
        tabela.put("inicio", INICIO);
        tabela.put("varinicio",VARINICIO);
        tabela.put("varfim", VARFIM);
        tabela.put("escreva", ESCREVA);
        tabela.put("leia", LEIA);
        tabela.put("se", SE);
        tabela.put("entao", ENTAO);
        tabela.put("fimse", FIMSE);
        tabela.put("fim", FIM);
        tabela.put("literal", LITERAL);
        tabela.put("inteiro", INTEIRO);
        tabela.put("real", REAL);
        
    }
    
    Token palavrasReservadas(Token token1) {
        while(tabela.get(token1.lexema)!=null){
            if(tabela.get(token1)==token1)
                tabela.get(token1.lexema);
           // System.out.println(tabela.get(token1.lexema));
                return tabela.get(token1.lexema);
        }
        return token1.ID;
    }
    
}
