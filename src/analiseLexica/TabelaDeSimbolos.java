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
        String lexema[]={"inicio","varinicio","varfim","escreva","leia", "se", "entao", "fimse", "fim","literal","inteiro","real"};
        Token token[]={INICIO,VARINICIO,VARFIM, ESCREVA , LEIA, SE, ENTAO, FIMSE, FIM,LITERAL,NUM,NUM};
        for(int i=0;i<token.length;i++){
            token[i].lexema=lexema[i];
            tabela.put(token[i].lexema, token[i]);
        }
    }
    
    Token palavrasReservadas(Token token1) {
        while(tabela.get(token1.lexema)!=null){
            if(tabela.get(token1)==token1)
            System.out.println(tabela.get(token1.lexema));;
            
                return tabela.get(token1.lexema);
        }
        return token1.ID;
    }
    
}
