package com.mycompany.tde03;
import org.jfree.data.category.DefaultCategoryDataset;

public class TDE03 {
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        int[] seeds = {9,21,27,81,243};
        int testes=5;
        
        Quicksort qs = new Quicksort(tamanhos, seeds, testes);
        CountingSort cs = new CountingSort(tamanhos, seeds, testes);
        Graficos grafico = new Graficos();
        
        DefaultCategoryDataset tempoQS = new DefaultCategoryDataset();
        DefaultCategoryDataset dadosQS = new DefaultCategoryDataset();
        DefaultCategoryDataset tempoCS = new DefaultCategoryDataset();
        DefaultCategoryDataset dadosCS = new DefaultCategoryDataset();
        
        qs.sort(tempoQS, dadosQS);
        cs.sort(tempoCS, dadosCS);
        
        grafico.graficoTempo(tempoQS,"Quicksort");
        grafico.graficoTI(dadosQS,"Quicksort");
        grafico.graficoTempo(tempoCS,"Countingsort");
        grafico.graficoTI(dadosCS,"Countingsort");

    }
}
