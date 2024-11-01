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
        
        DefaultCategoryDataset tempo = new DefaultCategoryDataset();
        DefaultCategoryDataset dadosQ = new DefaultCategoryDataset();
        DefaultCategoryDataset dadosC = new DefaultCategoryDataset();
        
        qs.sort(tempo, dadosQ);
        cs.sort(tempo, dadosC);
        
        grafico.graficoTempo(tempo);
        grafico.graficoTI(dadosQ, "QuickSort");
        grafico.graficoTI(dadosC, "CountingSort");

    }
}
