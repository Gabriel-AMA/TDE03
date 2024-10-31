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
public class Quicksort {
    private long troca;
    private long iteracoes;
    private long tempo;

    public Quicksort(){
        this.troca=0;
        this.iteracoes=0;
        this.tempo=0;
    }


    public void sort(int[][]listas, int tamanho){
        this.troca=0;
        this.iteracoes=0;
        long comeco=System.nanoTime();
        for(int[] lista:listas){
            sort(lista,0,tamanho-1);
        }
        long fim=System.nanoTime();
        this.tempo=(fim-comeco)/5/1000000;
    }
    public void sort(int[] lista, int inferior, int superior){
        this.iteracoes++;
        if(inferior<superior){
            int pivo = particao(lista, inferior, superior);
            sort(lista,inferior,pivo-1);
            sort(lista,pivo+1, superior);
        }
    }
    private int particao(int[] lista, int inferior, int superior){
        int pivo = lista[superior];
        int proPivo = inferior-1;
        for(int i= inferior; i < superior; i++){
            if(lista[i]<=pivo){
                proPivo++;
                int temp = lista[proPivo];
                lista[proPivo] = lista[i];
                lista[i] = temp;
                this.troca++;
            }
        }
        int temp = lista[proPivo+1];
        lista[proPivo+1]= lista[superior];
        lista[superior] = temp;
        return proPivo+1;
    }
    
    public void resultados(){
        
        long minutos = (this.tempo / 1000) / 60;
        long segundos = (this.tempo / 1000) % 60;
        long miliSegundos = this.tempo % 1000;

        String tempoFinal = String.format("%02d:%02d:%03d", minutos, segundos, miliSegundos);
        
        System.out.println("Numero total de trocas: " + this.troca);
        System.out.println("Numero total de iteracoes: " + this.iteracoes);
        System.out.println("Tempo de execucao: " + tempoFinal);
    }
    
    public void grafico(DefaultCategoryDataset tempoMedio, DefaultCategoryDataset dados, int tamanho){
        tempoMedio.addValue(this.tempo, "Quicksort", Integer.toString(tamanho));
        dados.addValue(this.troca, "Troca", Integer.toString(tamanho));
        dados.addValue(this.iteracoes, "Troca", Integer.toString(tamanho));
        
        
        
    }
}

