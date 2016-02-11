/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiseSintatica;

import analiseLexica.AnalisadorLexico;
import analiseLexica.TabelaDeSimbolos;
import AnaliseSemantica.AnalisadorSemantico;
import java.util.Stack;
import analiseLexica.Token;

/**
 *
 * @author Ronaldo Gomes
 */
public class AnalisadorSintatico {

	String path = "src/analiseLexica/Teste.txt";
	TabelaSintatica tabela = new TabelaSintatica();
	AnalisadorLexico an = new AnalisadorLexico();
	Stack<Object> pilha = new Stack<>();
	String numColuna[] = { "inicio", "varinicio", "varfim", "PT_V", "id",
			"inteiro", "real", "literal", "leia", "escreva", "num", "rcb",
			"opm", "se", "AB_P", "FC_P", "entao", "opr", "fimse", "fim", "EOF",
			"P", "V", "A", "LV", "D", "TIPO", "ES", "ARG", "CMD", "LD", "OPRD",
			"COND", "CABECALHO", "CORPO", "EXP_R" };
	String gramatica[] = { "P' P", "P inicio V A", "V varinicio LV", "LV D LV",
			"LV varfim ;", "D id TIPO ;", "TIPO int", "TIPO real",
			"TIPO literal", "A ES A", "ES leia id ;", "ES escreva ARG ;",
			"ARG literal", "ARG num", "ARG id", "A CMD A", "CMD id rcb LD ;",
			"LD OPRD opm OPRD", "LD OPRD", "OPRD id", "OPRD num", "A COND A",
			"COND CABECALHO CORPO", "CABECALHO se ( EXP_R ) entao",
			"EXP_R OPRD opr OPRD", "CORPO ES CORPO", "CORPO CMD CORPO",
			"CORPO COND CORPO", "CORPO fimse", "A fim" };

	/**
	 * @param tabelaDeSimbolos
	 * @return
	 */
	public String analisaSintaxe(TabelaDeSimbolos tabelaDeSimbolos) {
		Integer s;
		Token a;
		Token ip = an.analisaLexema(path, tabelaDeSimbolos); 
		pilha.push(0);
		int sLinha;
		while (true) {
			s = (Integer) pilha.peek(); 
			a = ip; 
			if (acao(s, a).substring(0, 1).equalsIgnoreCase("S")) { 
				this.pilha.push(a);
				sLinha = Integer.parseInt((acao(s, a).substring(1, acao(s, a)
						.length())));
				this.pilha.push(sLinha);
				ip = an.analisaLexema(path, tabelaDeSimbolos);
			} else if (acao(s, a).substring(0, 1).equalsIgnoreCase("R")) {
				int numRegraDeProducao = Integer.parseInt(acao(s, a).substring(
						1, acao(s, a).length())) - 1;
				int tamanhoDeBeta = (gramatica[numRegraDeProducao].split(" ").length) - 1;
				for (int i = 0; i < 2 * tamanhoDeBeta; i++) {
					this.pilha.pop();
				}
				sLinha = (int) this.pilha.peek();
				String regraDeProducao[] = gramatica[numRegraDeProducao]
						.split(" ");
				this.pilha.push(regraDeProducao[0]);
				this.pilha.push(desvio(sLinha, regraDeProducao[0]));
                                System.out.print(regraDeProducao[0]+" -> ");
                                for(int i=1;i<regraDeProducao.length;i++){
                                    System.out.print(regraDeProducao[i]+" ");
                                }
                                System.out.println("");
                                AnalisadorSemantico.analisaRegraSemantica(numRegraDeProducao+1);
			} else if (acao(s, a).equalsIgnoreCase("ACEITE")) {

				System.out.println("ACEITOU");
				return "ACEITOU";
			} else {
				System.out.println("ERRO");
				return "ERRO";
			}
		}
	}

	/**
	 * @param s
	 *            estado captado do topo da pilha no inicio do laço
	 * @param a
	 *            Token
	 * @return - String da posição da tabela Sintatica EX: S16, R12
	 */
	public String acao(int s, Token a) {
		int colunaSimbolo = -2;
		for (int i = 0; i < numColuna.length; i++) {
			if (numColuna[i].equalsIgnoreCase(a.toString())) {
				return tabela.tabSintatica[s][i];
			}
		}

		return tabela.tabSintatica[s][colunaSimbolo];
	}

	// RETORNA O VALOR CALCULADO DO DESVIO OU -1
	public int desvio(int sLinha, String naoTerminal) {
		for (int i = 0; i < numColuna.length; i++) {
			if (numColuna[i].equalsIgnoreCase(naoTerminal)) {
				try {
					return Integer.parseInt(tabela.tabSintatica[sLinha][i]);
				} catch (NumberFormatException erro) {
					System.out.println(" erro no desvio " + erro);
				}
			}
		}
		return -1;
	}

}
