/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise;

import static analise.Token.*;
import java.util.Hashtable;

/**
 *
 * @author Ronaldo Gomes
 */
class TabelaDeSimbolos {
    Hashtable<String, Token> tabela = new Hashtable<>();

    public TabelaDeSimbolos() {
        String lexema[]={"inicio","varinicio","varfim","escreva","leia", "se", "entao", "fimse", "fim"};
        Token token[]={INICIO,VARINICIO,VARFIM, ESCREVA , LEIA, SE, ENTAO, FIMSE, FIM};
        for(int i=0;i<token.length;i++){
            token[i].lexema=lexema[i];
            tabela.put(token[i].lexema, token[i]);
        }
    }
    
    Token palavrasReservadas(Token token) {
        while(tabela.get(token.lexema)!=null){
            return tabela.get(token.lexema);
        }
        return token.ID;
    }
    
}
