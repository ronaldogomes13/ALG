/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnaliseSemantica;

import Main.EscreveEmArquivo;

/**
 *
 * @author Ronaldo Gomes
 */
public class AnalisadorSemantico {
    
    public static void analisaRegraSemantica(int regraSintatica){
        String pathArquivoObjegto=javax.swing.filechooser.FileSystemView.getFileSystemView().getDefaultDirectory()+"/ProjetoALG/programa.c";
        switch(regraSintatica){
            case 5:
                //Imprimir três linhas brancas no arquivo objeto;
                EscreveEmArquivo.escreve(pathArquivoObjegto, "", true);
                EscreveEmArquivo.escreve(pathArquivoObjegto, "", true);
                EscreveEmArquivo.escreve(pathArquivoObjegto, "", true);
                
            case 6:
                //id.tipo <-- TIPO.tipo
                //Imprimir ( TIPO.tipo id.lexema
            case 7: 
                //TIPO.tipo <-- int.tipo
            case 8:
                //TIPO.tipo <-- real.tipo
            case 9:
                //TIPO.tipo <-- lit.tipo
            case 11:
                /**
                 * Verificar se o campo tipo do identificador está preenchido indicando a
                    declaração do identificador (execução da regra semântica de número 6).
                    Se sim, então:
                     Se id.tipo = literal Imprimir ( scanf(“%s”, id.lexema); )
                     Se id.tipo = inteiro Imprimir ( scanf(“%d”, &id.lexema); )
                     Se id.tipo = real Imprimir ( scanf(“%lf”, &id.lexema); )
                    Caso Contrário:
                    Emitir na tela “Erro: Variável não declarada”.
                 */
            case 12:
                /**
                 * Gerar código para o comando escreva no arquivo objeto.
                *    Imprimir ( printf(“ARG.lexema”); )
                 */
            case 13:
                /**
                 * ARG.atributos ß literal.atributos (Copiar todos os atributos de literal
                 * para os atributos de ARG).
                 */
            case 14: 
                /**
                 * ARG.atributos ß num.atributos (Copiar todos os atributos de literal para
                 * os atributos de ARG).
                 */
            case 15:
                /**
                 * Verificar se o identificador foi declarado (execução da regra semântica de
                 * número 6).
                 * Se sim, então:
                 * ARG.atributos ß id.atributos (copia todos os atributos de id para os
                 * de ARG).
                 * Caso Contrário:
                 * Emitir na tela “Erro: Variável não declarada”.
                 */
            case 17:
                /**
                 * Verificar se id foi declarado (execução da regra semântica de número 6).
                 * Se sim, então:
                 * Realizar verificação do tipo entre os operandos id e LD (ou seja, se
                 * ambos são do mesmo tipo).
                 * Se sim, então:
                 *Imprimir (id.lexema rcb.tipo LD.lexema) no arquivo objeto.
| Caso contrário emitir:”Erro: Tipos diferentes para atribuição”.
Caso contrário emitir “Erro: Variável não declarada”.
                 */
            case 18:
                /*
                Verificar se tipo dos operandos são equivalentes e diferentes de literal.
                Se sim, então:
                Gerar uma variável numérica temporária Tx, em que x é um número
                gerado sequencialmente.
                LD.lexema ß Tx
                Imprimir (Tx = OPRD.lexema opm.tipo OPRD.lexema) no
                arquivo objeto.
                Caso contrário emitir “Erro: Operandos com tipos incompatíveis”.
                */
            case 19:
                /**
                 * LD.atributos ß OPRD.atributos (Copiar todos os atributos de OPRD para
                   os atributos de LD).
                 */
            case 20:
                /**
                 * Verificar	se	o	identificador	está	declarado.
                    Se sim, então:
                    OPRD.atributos	ß id.atributos
                    Caso contrário emitir “Erro: Variável não declarada”
                 */
            case 21: 
                /**
                 * OPRD.atributos	ß num.atributos (Copiar todos os atributos de num para os
                   atributos de OPRD).
                 */
            case 23:
                /**
                 * Imprimir ( } ) no arquivo objeto
                 */
            case 24:
                /**
                 * Imprimir ( if (EXP_R.lexema)	{ ) no arquivo objeto.
                 */
            case 25:
                /**
                 * Verificar se os tipos de dados de OPRD são iguais ou equivalentes para a
                 * realização de comparação relacional.
                 * Se sim, então:
                 * Gerar uma variável booleana temporária Tx, em que x é um número
                 * gerado sequencialmente.
                 * EXP_R.lexema <-- Tx             
                 * Imprimir (Tx = OPRD.lexema opr.tipo OPRD.lexema) no arquivo objeto.
                 *  Caso contrário emitir “Erro: Operandos com tipos incompatíveis”.
                 */
                
                
        }
    }
}
