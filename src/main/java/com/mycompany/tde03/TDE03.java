package com.mycompany.tde03;

import java.util.Random;
import org.jfree.data.category.DefaultCategoryDataset;

public class TDE03 {
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        int[] seeds = {9,21,27,81,243};
        
        
        //Quicksort qs = new Quicksort();
        Gnomesort gs = new Gnomesort();
        Graficos grafico = new Graficos();
        
        
        //DefaultCategoryDataset TempoQS = new DefaultCategoryDataset();
        //DefaultCategoryDataset dadosQS = new DefaultCategoryDataset();
        DefaultCategoryDataset TempoGS = new DefaultCategoryDataset();
        DefaultCategoryDataset dadosGS = new DefaultCategoryDataset();

        for (int tamanho: tamanhos) {
            for (int seed: seeds){
                Random random = new Random(seed);
                //int[] listaQ = new int[tamanho];
                int[] listaG = new int[tamanho];
                for (int l = 0; l < tamanho; l++) {
                    //listaQ[l] = random.nextInt();
                    listaG[l] = random.nextInt();
                }
                //qs.Sort(listaQ);
                gs.Sort(listaG, tamanho);
                }
            System.out.println("-----Tamanho da Lista: "+tamanho+"-----");
            gs.resultados(TempoGS, dadosGS, tamanho);
            }
        //grafico.graficoTempo(datasetTempoQS);
        //grafico.graficoTI(datasetQS);
        grafico.graficoTempo(TempoGS);
        grafico.graficoTI(dadosGS, "GnomeSort");

    }
}
