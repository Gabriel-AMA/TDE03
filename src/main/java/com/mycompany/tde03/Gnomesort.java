/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;
import java.util.Random;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author otaku
 */

public class Gnomesort {
    private long troca;
    private long iteracoes;
    private long tempoExe;
    private final int[] tamanhos;
    private final int[] seeds;
    private final int size;
    private final int[][] listas;

    public Gnomesort(int[] tamanhos, int[] seeds, int size){
        this.troca=0;
        this.iteracoes=0;
        this.tempoExe=0;
        this.tamanhos = tamanhos;
        this.seeds=seeds;
        this.size=size;
        this.listas = new int[size][];
    }
    
    public void gerarDados(int tamanho){
        for (int i = 0; i<this.size;i++){
            Random random = new Random(seeds[i]);
            int[] lista = new int[tamanho];
            for (int l = 0; l < tamanho; l++) {
                lista[l] = random.nextInt();
            }
            this.listas[i]=lista;
        }
    }
    
    public void sort(DefaultCategoryDataset tempo, DefaultCategoryDataset dados){
        for (int tamanho: tamanhos){
            this.troca=0;
            this.iteracoes=0;
            this.tempoExe=0;
            gerarDados(tamanho);
            for(int[] lista: listas){
                long comeco = System.currentTimeMillis();
                sort(lista,tamanho);
                long fim = System.currentTimeMillis();
                this.tempoExe +=fim-comeco;
            }
            this.tempoExe=this.tempoExe/this.size;
            this.troca = this.troca/this.size;
            this.iteracoes = this.iteracoes/this.size;
            resultados(tamanho);
            tempo.addValue(this.tempoExe,"GnomeSort",Integer.toString(tamanho));
            dados.addValue(this.troca,"Troca",Integer.toString(tamanho));
            dados.addValue(this.iteracoes,"Iterações",Integer.toString(tamanho));
        }
    }
    
    
    public void sort(int[] lista, int tamanho) {
        int index=0;
        while (index < tamanho-1){
            this.iteracoes++;
            if (index==0 || lista[index] >= lista[index-1]) {
                index++;
            } else {
                int temp = lista[index];
                lista[index] = lista[index-1];
                lista[index-1] = temp;
                index--;
                this.troca++;

            }
        }
    }
    public void resultados(int tamanho){
        long miliSegundos = this.tempoExe%1000;
        long segundos = (this.tempoExe / 1000) % 60;
        long minutos = (this.tempoExe / 1000) / 60;

        // Formatar tempo final como uma string
        String tempoFinal = String.format("%02d:%02d:%03d", minutos, segundos, miliSegundos);
        System.out.println("-----Gnomesort - Tamanho:" + tamanho+"-----");
        System.out.println("Numero total de trocas: " + this.troca);
        System.out.println("Numero total de iteracoes: " + this.iteracoes);
        System.out.println("Tempo de execucao: " + tempoFinal);
    }  
    
}

