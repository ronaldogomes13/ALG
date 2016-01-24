/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseSintatica;

import analiseLexica.AnalisadorLexico;
import analiseLexica.Token;
import java.util.Stack;
import analiseLexica.Token;


/**
 *
 * @author Ronaldo Gomes
 */
public class AnalisadorSintatico {
    //vetor que identifica as colunas da tabela sintatica
        String numColuna [] = {"inicio", "varinicio", "varfim","PT_V", "id", "inteiro", "real", "literal",
            "leia", "escreva", "num", "rcb", "opm", "se", "AB_P", "FC_P", "entao", "opr", "fimse", "fim", "EOF","P","V","A","LV",
        "D","TIPO","ES","ARG","CMD", "LD", "OPRD","COND", "CABECALHO", "CORPO", "EXP_R"};
    String path = "src/analiseLexica/Teste.txt";
    AnalisadorLexico an = new AnalisadorLexico();
    TabelaSintatica tabela = new TabelaSintatica();
    Stack pilha = new Stack();
    String gramatica[]={"P' P","P inicio V A","V varinicio", "LV D LV","LV varfim ;", "D id TIPO ;","TIPO int","TIPO real",
    "TIPO literal","A ES A","ES leia id ;","ES escreva ARG ;","ARG literal","ARG num", "ARG id","A CMD A", "CMD id rcb LD ;",
    "LD OPRD opm OPRD", "LD OPRD", "OPRD id", "OPRD num", "A COND A", "COND CABECALHO CORPO", "CABECALHO se ( EXP_R ) entao", 
    "EXP_R OPRD opr OPRD", "CORPO ES CORPO", "CORPO CMD CORPO", "CORPO COND CORPO", "CORPO fimse", "A fim"};
    
    public void analisaSintaxe(){
        Integer s;
            Token a;
            Token ip = an.analisaLexema(path); 
            pilha.push(0);
            int sLinha;
       int in =0;
          while(in<8){//COLOCAR O LIMITE DE PARADA $ 
            s=(Integer) pilha.peek();
            a=ip; 
             
            if(acao(s,a).substring(0,1).equalsIgnoreCase("S")){   
                this.pilha.push(a);
                 sLinha = Integer.parseInt((acao(s,a).substring( 1, acao(s,a).length() ) ));
                this.pilha.push(sLinha );
                ip=an.analisaLexema(path);
            }else if(acao(s,a).substring(0,1).equalsIgnoreCase("R")){
                
                sLinha=Integer.parseInt(acao(s,a).substring(1, acao(s,a).length())); //S 16 por exemplo numRegraGramatical=16
                int tamanhoBeta=gramatica[sLinha+1].split(" ").length - 1;
                for(int i =0; i< 2*tamanhoBeta;i++){
                    this.pilha.pop();
                }
                sLinha = (int) this.pilha.peek();
                String reg[]=gramatica[sLinha-1].split(" ");
                this.pilha.push(reg[0]);
                acao(sLinha,a);
                this.pilha.push(desvio(sLinha,reg[0]));     
            }else if(acao(s,a).equalsIgnoreCase("ACEITE")){
               System.out.println("ACEITOU");
                
            }else{
                System.out.println("ERRO");
                
            }     
          in++; 
        }
    }
    public String acao(int s, Token a){  
        int colunaSimbolo=-1;
        
         for(int i=0;i<numColuna.length;i++){
            if(numColuna[i].equalsIgnoreCase(a.toString()) && !a.tipo.isEmpty()){
                if(a.tipo.equalsIgnoreCase("inteiro")){
                  colunaSimbolo=5;  
                }else if(a.tipo.equalsIgnoreCase("real")){
                    colunaSimbolo=6;
                }
                
            }else if(numColuna[i].equalsIgnoreCase(a.toString()) && a.tipo.isEmpty() ){
               colunaSimbolo=i;
            }
        }
         //retorna a string da tabela sintatica Exempo "S 10"
         return tabela.retornaValorTabela(s, colunaSimbolo);       
}
    //RETORNA O VALOR CALCULADO DO DESVIO OU -1 
    public int desvio(int estado, String naoTerminal){
        for(int i=0; i<numColuna.length;i++){
            
            if(numColuna[i].equalsIgnoreCase(naoTerminal)){
               
                return i;
            }
        }
       return -1; 
    }
}
