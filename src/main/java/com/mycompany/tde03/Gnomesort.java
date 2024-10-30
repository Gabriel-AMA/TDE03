/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author otaku
 */

public class Gnomesort {
    private long numSwap;
    private long numIteracoes;
    private long tempoExe;

    public Gnomesort(){
        this.numSwap=0;
        this.numIteracoes=0;
        this.tempoExe=0;
    }
    
    
    public void Sort(int[] lista, int tamanho) {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        int index=0;
        while (index < tamanho-1){
            this.numIteracoes++;
            if (index==0 || lista[index] >= lista[index-1]) {
                index++;
            } else {
                int temp = lista[index];
                lista[index] = lista[index-1];
                lista[index-1] = temp;
                index--;
                this.numSwap++;

            }
        }
        this.tempoExe += endTime - startTime;
    }
    public void resultados(DefaultCategoryDataset dados, DefaultCategoryDataset tempo, int tamanho) {
        long minutos = (this.tempoExe / 1000) / 60;
        long segundos = (this.tempoExe / 1000) % 60;
        long miliSegundos = this.tempoExe % 1000;
        
        tempo.addValue(this.tempoExe/5, "Gnomesort", Integer.toString(tamanho));
        dados.addValue(this.numSwap/5, "Troca", Integer.toString(tamanho));
        dados.addValue(this.numIteracoes/5, "Iterações", Integer.toString(tamanho));
        
        String tempoFinal = String.format("%02d:%02d:%03d", minutos, segundos, miliSegundos);
        System.out.println("---Resultados GnomeSort---");
        System.out.println("Numero total de trocas: " + this.numSwap);
        System.out.println("Numero total de iteracoes: " + this.numIteracoes);
        System.out.println("Tempo de Execucao: "+tempoFinal);
    }
    
}

