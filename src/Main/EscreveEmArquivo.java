/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ronaldo Gomes
 */
public class EscreveEmArquivo {
    public static void escreve(String pathArquivoObjeto, String linha, boolean manterConteudo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				pathArquivoObjeto, manterConteudo));) {
			writer.write(linha);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
