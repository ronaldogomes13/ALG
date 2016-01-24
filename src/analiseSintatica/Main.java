/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseSintatica;

import analiseLexica.AnalisadorLexico;
import analiseLexica.Token;

/**
 *
 * @author Ronaldo Gomes
 */
public class Main {
    public static void main(String args[]){
        AnalisadorSintatico analisador = new AnalisadorSintatico();
        analisador.analisaSintaxe();
    }
    
}
