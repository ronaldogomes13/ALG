/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseSintatica;

import analiseLexica.TabelaDeSimbolos;

/**
 *
 * @author Ronaldo Gomes
 */
public class Main {
    public static void main(String args[]){
        TabelaDeSimbolos tabelaDeSimbolos = new TabelaDeSimbolos();
        AnalisadorSintatico analisador = new AnalisadorSintatico();
        analisador.analisaSintaxe(tabelaDeSimbolos);  
    }
    
}
