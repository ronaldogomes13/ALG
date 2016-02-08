/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseLexica;
/**
 *
 * @author Ronaldo Gomes
 */
public class OperaTabelaDeSimbolos {
    
    /**
     *
     * @param token
     * @param tabSimbolos
     * @return
     */
    public  static Token insereNaTabSimbolos(Token token, TabelaDeSimbolos tabSimbolos) {
        if(tabSimbolos.tabela.get(token.lexema)!=null){
              return tabSimbolos.tabela.get(token.lexema);
        }else{
        tabSimbolos.tabela.put(token.lexema, token);
        return token;
        }
    }
  
  public  static void imprimeTabDeSimbolos(TabelaDeSimbolos tabSimbolos) {
      System.out.println("TABELA DE SIMBOLOS");
      System.out.println(tabSimbolos.tabela);
  }
    
}
