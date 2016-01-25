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
    String numColuna [] = {"inicio", "varinicio", "varfim","PT_V", "id", "inteiro", "real", "literal", "leia", "escreva", "num",
        "rcb", "opm", "se", "AB_P", "FC_P", "entao", "opr", "fimse", "fim", "EOF","P","V","A","LV", "D","TIPO","ES","ARG",
        "CMD", "LD", "OPRD","COND", "CABECALHO", "CORPO", "EXP_R"};
    String path = "src/analiseLexica/Teste.txt";
    AnalisadorLexico an = new AnalisadorLexico();
    TabelaSintatica tabela = new TabelaSintatica();
    Stack pilha = new Stack();
    String gramatica[]={"P' P","P inicio V A","V varinicio", "LV D LV","LV varfim ;", "D id TIPO ;","TIPO int","TIPO real",
    "TIPO literal","A ES A","ES leia id ;","ES escreva ARG ;","ARG literal","ARG num", "ARG id","A CMD A", "CMD id rcb LD ;",
    "LD OPRD opm OPRD", "LD OPRD", "OPRD id", "OPRD num", "A COND A", "COND CABECALHO CORPO", "CABECALHO se ( EXP_R ) entao", 
    "EXP_R OPRD opr OPRD", "CORPO ES CORPO", "CORPO CMD CORPO", "CORPO COND CORPO", "CORPO fimse", "A fim"};
    
    public String analisaSintaxe(){
        Integer s;
            Token a;
            Token ip = an.analisaLexema(path); //fazer ip apontar para o 1° simbolo w$
            pilha.push(0);
            int sLinha;
          while(true){//repetir para sempre 
            s=(Integer) pilha.peek(); //Seja S o estado ao topo da pilha
            a=ip; //a o simbolo apontado por ip
             
            if(acao(s,a).substring(0,1).equalsIgnoreCase("S")){   //se acao[s,a]=empilhar
                this.pilha.push(a);//empilhar a
                 sLinha = Integer.parseInt((acao(s,a).substring( 1, acao(s,a).length() ) ));
                this.pilha.push(sLinha );//e em seguida sLinha no topo da pilha
                ip=an.analisaLexema(path);//avançar ip para o proximo simbolo
            }else if(acao(s,a).substring(0,1).equalsIgnoreCase("R")){//se acao(s,a)=reduzir             
                sLinha=Integer.parseInt(acao(s,a).substring(1, acao(s,a).length())); 
                int tamanhoBeta=gramatica[sLinha+1].split(" ").length - 1;
                //desempilhar 2*|beta| simbolos para fora da pilha
                for(int i =0; i< 2*tamanhoBeta;i++){
                    this.pilha.pop();
                }
                sLinha = (int) this.pilha.peek();//seja sLinha o estado ao topo da pilha
                String[] producao=gramatica[sLinha-1].split(" ");
                this.pilha.push(producao[0]);//empilhar A (lado esquerdo da produção)
                this.pilha.push(desvio(sLinha,producao[0])); //e em seguida desvio(sLinha,A)    
                System.out.println(gramatica[sLinha-1]);//escrever a produção A-> Beta na tela
            }else if(acao(s,a).equalsIgnoreCase("ACEITE")){//se acao(s,a)=aceitar
               System.out.println("ACEITOU");
               return "ACEITOU";//retornar
                
            }else{
                System.out.println("ERRO");
                return "ERRO";               
                
            }     
        }
    }
    /**
     * @param s  estado captado do topo da pilha no inicio do laço
     * @param a Token 
     * @return - String da posição da tabela Sintatica EX: S16, R12
     */
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
    public int desvio(int sLinha, String naoTerminal){
        for(int i=0; i<numColuna.length;i++){ 
            if(numColuna[i].equalsIgnoreCase(naoTerminal)){
               try{
                return  Integer.parseInt(tabela.tabSintatica[sLinha][i]);
               }catch(NumberFormatException erro){
                   System.out.println(erro);
               }
            }
        }
       return -1; 
    }
}
