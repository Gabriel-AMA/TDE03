package com.mycompany.tde03;

import java.util.Random;
import org.jfree.data.category.DefaultCategoryDataset;

public class TDE03 {
    
    public static int[] gerarLista(Random random, int tamanho){
        int[] lista = new int[tamanho];
        for (int l = 0; l < tamanho; l++) {
            lista[l] = random.nextInt();
        }
        return lista;
    }
    
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        int[] seeds = {9,21,27,81,243};
        
        int[][] listas = new int[5][];
        
        DefaultCategoryDataset tempoQuick =  new DefaultCategoryDataset();
        DefaultCategoryDataset dadosQuick = new DefaultCategoryDataset();
        
        Quicksort qs = new Quicksort();
        //Gnomesort gs = new Gnomesort();

        Graficos grafico = new Graficos();

        for (int tamanho: tamanhos) {
            for (int i=0;i<5;i++){
                Random random = new Random(seeds[i]);
                int[] lista = gerarLista(random, tamanho);
                listas[i] = lista;
                }
            qs.sort(listas, tamanho);
            System.out.println("----- Tamanho: "+tamanho+"-----");
            qs.resultados();
            qs.grafico(tempoQuick, dadosQuick, tamanho);
            
            }
        grafico.graficoTempo(tempoQuick);
        grafico.graficoDados(dadosQuick, "Quicksort");

    }
}
