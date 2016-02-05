/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseSintatica;

import analiseLexica.Token;

/**
 *
 * @author Ronaldo Gomes
 */
public class NumColunaTabSintatica {
    public static int numColuna(Token a){
                            
        if(a.toString().equalsIgnoreCase("inicio"))
            return 0;
        if(a.toString().equalsIgnoreCase("varincio"))
            return 1;
        if(a.toString().equalsIgnoreCase("varfim"))
            return 2;
        if(a.toString().equalsIgnoreCase("PT_V"))
            return 3;
        if(a.toString().equalsIgnoreCase("id"))
            return 4;
        if(a.toString().equalsIgnoreCase("inteiro"))
            return 5;
        if(a.toString().equalsIgnoreCase("real"))
            return 6;
        if(a.toString().equalsIgnoreCase("literal"))
            return 7;
        if(a.toString().equalsIgnoreCase("leia"))
            return 8;
        if(a.toString().equalsIgnoreCase("escreva"))
            return 9;
        if(a.toString().equalsIgnoreCase("num"))
            return 10;
        if(a.toString().equalsIgnoreCase("rcb"))
            return 11;
        if(a.toString().equalsIgnoreCase("opm"))
            return 12;
        if(a.toString().equalsIgnoreCase("se"))
            return 13;
        if(a.toString().equalsIgnoreCase("AB_P"))
            return 14;
        if(a.toString().equalsIgnoreCase("FC_P"))
            return 15;
        if(a.toString().equalsIgnoreCase("entao"))
            return 16;
        if(a.toString().equalsIgnoreCase("opr"))
            return 17;
        if(a.toString().equalsIgnoreCase("fimse"))
            return 18;
        if(a.toString().equalsIgnoreCase("fim"))
            return 19;
        if(a.toString().equalsIgnoreCase("EOF"))
            return 20;
        if(a.toString().equalsIgnoreCase("P"))
            return 21;
        if(a.toString().equalsIgnoreCase("V"))
            return 22;
        if(a.toString().equalsIgnoreCase("A"))
            return 23;
        if(a.toString().equalsIgnoreCase("LV"))
            return 24;
        if(a.toString().equalsIgnoreCase("D"))
            return 25;
        if(a.toString().equalsIgnoreCase("TIPO"))
            return 26;
        if(a.toString().equalsIgnoreCase("ES"))
            return 27;
        if(a.toString().equalsIgnoreCase("ARG"))
            return 28;
        if(a.toString().equalsIgnoreCase("CMD"))
            return 29;
        if(a.toString().equalsIgnoreCase("LD"))
            return 30;
        if(a.toString().equalsIgnoreCase("OPRD"))
            return 31;
        if(a.toString().equalsIgnoreCase("COND"))
            return 32;
        if(a.toString().equalsIgnoreCase("CABECALHO"))
            return 33;
        if(a.toString().equalsIgnoreCase("CORPO"))
            return 34;
        if(a.toString().equalsIgnoreCase("EXP_R")) 
            return 35;
        return -1;
    }    
}
