package com.mycompany.tde03;

import java.util.Random;
import org.jfree.data.category.DefaultCategoryDataset;

public class TDE03 {
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        int[] seeds = {9,21,27,81,243};
        Quicksort qs = new Quicksort();
        Gnomesort gs = new Gnomesort();
        DefaultCategoryDataset datasetTempoQS = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetTrocaQS = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetIteracoesQS = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetTempoGS = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetTrocaGS = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetIteracoesGS = new DefaultCategoryDataset();
        Graficos grafico = new Graficos();

        for (int i = 0; i < tamanhos.length; i++) {
            long somaTempo = 0;
            long somaTempoGS = 0;
            for (int j = 0; j<seeds.length;j++){
                Random random = new Random(seeds[j]);
                int[] lista = new int[tamanhos[i]];
                for (int l = 0; l < lista.length; l++) {
                    lista[l] = random.nextInt();
                }
                int[] listaqs = lista.clone();
                int[] listags = lista.clone();
                long startTime = System.nanoTime();
                qs.Sort(listaqs);
                long endTime = System.nanoTime();
                somaTempo += (endTime - startTime);
                long startTimeGS = System.nanoTime();
                gs.Sort(listags);
                long endTimeGS = System.nanoTime();
                somaTempoGS += (endTimeGS - startTimeGS);
                }
            long tempoMedio = somaTempo / 5 / 1000000;
            long tempoMedioGS = somaTempoGS / 5 / 1000000;
            datasetTempoQS.addValue(tempoMedio, "Quicksort", Integer.toString(tamanhos[i]));
            datasetTempoGS.addValue(tempoMedioGS, "Gnomesort", Integer.toString(tamanhos[i]));
            datasetTrocaQS.addValue(qs.getNumSwap(), "Quicksort", Integer.toString(tamanhos[i]));
            datasetTrocaGS.addValue(gs.getNumSwap(), "Gnomesort", Integer.toString(tamanhos[i]));
            datasetIteracoesQS.addValue(qs.getNumIteracoes(), "Quicksort", Integer.toString(tamanhos[i]));
            datasetIteracoesGS.addValue(gs.getNumIteracoes(), "Gnomesort", Integer.toString(tamanhos[i]));
            System.out.println("-----TAMANHO: " + tamanhos[i]+"-----");
            System.out.println("QuickSort");
            System.out.println(" - Tempo medio: " + tempoMedio + " ms");
            System.out.println(" - Numero de trocas: "+ qs.getNumSwap());
            System.out.println(" - Numero de Iteracoes: "+ qs.getNumIteracoes());
            System.out.println("GnomeSort");
            System.out.println(" - Tempo medio: " + tempoMedioGS + " ms");
            System.out.println(" - Numero de trocas: "+ gs.getNumSwap());
            System.out.println(" - Numero de Iteracoes: "+ gs.getNumIteracoes());
            }
        grafico.graficoTempo(datasetTempoQS);
        grafico.graficoTroca(datasetTrocaQS);
        grafico.graficoIteracoes(datasetIteracoesQS);
        grafico.graficoTempo(datasetTempoGS);
        grafico.graficoTroca(datasetTrocaGS);
        grafico.graficoIteracoes(datasetIteracoesGS);

    }
}
