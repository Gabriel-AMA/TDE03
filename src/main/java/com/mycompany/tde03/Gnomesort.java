/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;

/**
 *
 * @author otaku
 */

public class Gnomesort {
    private long numSwap;
    private int numIteracoes;
    private long tempo;

    public Gnomesort(){this.numSwap=0;this.numIteracoes=0;}

    public int[] Sort(int[] a) {
        this.numSwap=0;
        this.numIteracoes=0;
        long startTime = System.currentTimeMillis();
        int index=0;
        while (index < a.length){
            this.numIteracoes++;
            if (index==0 || a[index] >= a[index-1]) {
                index++;
            } else {
                int temp = a[index];
                a[index] = a[index-1];
                a[index-1] = temp;
                index--;
                this.numSwap++;

            }
        }
        long endTime = System.currentTimeMillis();
        this.tempo = endTime - startTime;
        return a;
    }
    public String temporizador() {
        long minutos = (this.tempo / 1000) / 60;
        long segundos = (this.tempo / 1000) % 60;
        long miliSegundos = this.tempo % 1000;

        // Formatar tempo final como uma string
        String tempoFinal = String.format("%02d:%02d:%03d", minutos, segundos, miliSegundos);
        return tempoFinal;
    }
    
    public void resultados(){
        System.out.println("Numero total de trocas: " + this.numSwap);
        System.out.println("Numero total de iteracoes: " + this.numIteracoes);
        System.out.println("Tempo de execucao: " + temporizador());
    }


    public long getNumSwap(){
        return this.numSwap;
    }

    public int getNumIteracoes() {
        return this.numIteracoes;
    }
    public long getTempo(){
        return this.tempo;
    }
    
}

