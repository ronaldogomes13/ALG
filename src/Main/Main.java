/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import analiseLexica.TabelaDeSimbolos;
import analiseSintatica.AnalisadorSintatico;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Ronaldo Gomes
 */
public class Main {
    public String pathArquivoObjeto;

    public Main(){
         File diretorioDoObjeto = new File(javax.swing.filechooser.FileSystemView.getFileSystemView().getDefaultDirectory()+"/ProjetoALG/");
         this.pathArquivoObjeto=javax.swing.filechooser.FileSystemView.getFileSystemView().getDefaultDirectory()+"/ProjetoALG/programa.c";
         if(!(diretorioDoObjeto.exists())){
            try{
            diretorioDoObjeto.mkdirs();
            diretorioDoObjeto= new File(diretorioDoObjeto+"/programa.c");
            if(!diretorioDoObjeto.exists()){       
                diretorioDoObjeto.createNewFile(); 
            }
            }catch(IOException e){
                   System.out.println(e);
            }
        }else {
             diretorioDoObjeto= new File(diretorioDoObjeto+"/programa.c");
             if(!diretorioDoObjeto.exists()){
                 try{
                diretorioDoObjeto.createNewFile();
                 }catch(IOException e){
                    System.out.println(e);  
                 }         
             }
             EscreveEmArquivo.escreve(pathArquivoObjeto, "", false);
             EscreveEmArquivo.escreve(pathArquivoObjeto, "#include<stdio.h>", false);
             EscreveEmArquivo.escreve(pathArquivoObjeto, "typedef char literal[256];>", true);
             EscreveEmArquivo.escreve(pathArquivoObjeto, "void main(void){", true);
         }       
    }
    
    
     public static void main(String args[]){  
        new Main();
        TabelaDeSimbolos tabelaDeSimbolos = new TabelaDeSimbolos();
        AnalisadorSintatico analisador = new AnalisadorSintatico();
        analisador.analisaSintaxe(tabelaDeSimbolos);  
      
    }
    
}
