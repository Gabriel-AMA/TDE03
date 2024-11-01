/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author otaku
 */
public class Graficos {
    
    public void graficoTempo(DefaultCategoryDataset dataset){
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Tempo de Execução",
                "Tamanho do Vetor",
                "Tempo (ms)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        JFrame frame = new JFrame();
        frame.setContentPane(chartPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void graficoTI(DefaultCategoryDataset dataset, String nome){
        JFreeChart areaChart = ChartFactory.createBarChart(
                "Resultados" + nome, 
                "Tamanho do Vetor", 
                "Quantidade", 
                dataset);
        ChartPanel chartPanel = new ChartPanel(areaChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        JFrame frame = new JFrame();
        frame.setContentPane(chartPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    
}
