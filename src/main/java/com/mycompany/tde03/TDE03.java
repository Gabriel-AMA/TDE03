/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tde03;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author otaku
 */
public class TDE03 {
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        long[] temposQuicksort = new long[tamanhos.length];
        Quicksort qs = new Quicksort();
        Gnomesort gs = new Gnomesort();
        Random random = new Random(42);

        for (int i = 0; i < tamanhos.length; i++) {
            int[] lista = new int[tamanhos[i]];
            for (int j = 0; j < lista.length; j++) {
                lista[j] = random.nextInt();
            }

            long startTime = System.currentTimeMillis();
            //qs.Sort(lista);
            gs.Sort(lista);
            long endTime = System.currentTimeMillis();

            temposQuicksort[i] = endTime - startTime; // Armazena o tempo de execução
            long minutes = (temposQuicksort[i] / 1000) / 60;
            long seconds = (temposQuicksort[i] / 1000) % 60;
            long milliseconds = temposQuicksort[i] % 1000;
            System.out.println(tamanhos[i]);
            //System.out.println("Número total de trocas: " + qs.getNumSwap());
            //System.out.println("Número total de iterações: " + qs.getNumIteracoes());
            System.out.println("Número total de trocas: " + gs.getNumSwap());
            System.out.println("Número total de iterações: " + gs.getNumIteracoes());
            System.out.println("Tempo de execução: " + minutes + " minutos, " + seconds + " segundos e " + milliseconds + " milissegundos");
        }

        // Cria o dataset para o gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < tamanhos.length; i++) {
            dataset.addValue(temposQuicksort[i], "Quicksort", String.valueOf(tamanhos[i]));
        }

        // Cria o gráfico de linha
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Tempo de Execução do Quicksort",
                "Tamanho do Vetor",
                "Tempo (ms)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Exibe o gráfico
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        JFrame frame = new JFrame();
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

}
