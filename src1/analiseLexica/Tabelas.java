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
public class Tabelas {
    
    static int tabelaDeTransicao[][] =
   // 	L	D	{	}	"	<	>	=	-	+	*	/	(	)	;	EOF	E	pt	out	sp	\n	\t	underL	
{{	7,	1,	10,	-2,	8,	12,	13,	17,	20,	19,	21,	22,	23,	24,	25,	26,	7,	27,	27,	0,	0,	0,	27},// 0
{	27,	1,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	4,	2,	-2,	-2,	-2,	-2,	27},// 1 estado final
{	27,	3,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	-2,	-2,	-2,	-2,	-2,	-2},// 2
{	27,	3,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	4,	-2,	-2,	-2,	-2,	-2,	27},// 3 estado final
{	27,	6,	-2,	-2,	-2,	-2,	-2,	-2,	5,	5,	-2,	-2,	-2,	-2,	-2,	-2,	27,	-2,	-2,	-2,	-2,	-2,	-2},// 4
{	-2,	6,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 5
{	27,	6,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	27,	-2,	-2,	-2,	-2,	-2},// 6 estado final 
{	7,	7, 	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	7,	-2,	-2,	-2,	-2,	-2,	7},// 7	 estado final 
{	8,	8,	8,	8,	9,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	-2,	8,	8,	8,	8,	-2,	8,	8},// 8
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	-2,	-2},// 9 estado final
{	10,	10,	10,	11,	10,     10,     10,     10,	10,     10,     10,     10,	10,     10,     10,     -2,	10,     10,     10,     10,	10,     10,     10},// 10
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 11 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	16,	15,	18,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 12 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	14,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 13 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 14 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 15 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 16 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 17 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 18 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	27,	27,	27,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 19 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	27,	27,	27,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 20 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	27,	27,	27,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 21 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	27,	27,	27,	27,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 22 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 23 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 24 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 25 estado final
{	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2,	-2},// 26 estado final
{	27,	27,	27,	27,	27,	27,	27,	27,	27,	27,	27,	27,	27,	27,	27,	-2,	27,	27,	27,	-2,	-2,	-2,	27},// 27 testes 
};
  

}
