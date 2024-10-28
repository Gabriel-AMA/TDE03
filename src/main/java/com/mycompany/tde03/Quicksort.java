/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;

/**
 *
 * @author otaku
 */
public class Quicksort {
    private int numSwap;
    private int numIteracoes;
    private long tempo;

    public Quicksort(){this.numSwap=0;this.numIteracoes-=0;}


    public int[] Sort(int[]a){
        this.numSwap=0;
        this.numIteracoes=0;
        a = Sort(a, 0, a.length-1);
        return a;
    }
    public int[] Sort(int[] a, int inferior, int superior){
        this.numIteracoes++;
        if(inferior>=superior)
            return a;
        else{
            int pivo = particao(a, inferior, superior);
            a = Sort(a,inferior,pivo-1);
            a = Sort(a,pivo+1, superior);
        }
        return a;
    }
    private int particao(int[] a, int inferior, int superior){
        int pivo = a[superior];
        int propivo = inferior-1;
        for(int i= inferior; i < superior; i++){
            if(a[i]<=pivo){
                propivo++;
                int temp = a[propivo];
                a[propivo] = a[i];
                a[i] = temp;
                this.numSwap++;
            }
        }
        int temp = a[propivo+1];
        a[propivo+1]= a[superior];
        a[superior] = temp;
        return propivo+1;
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
    
    public int getNumSwap(){
        return this.numSwap;
    }

    public int getNumIteracoes() {
        return numIteracoes;
    }
    
    public long getTempo(){
        return this.tempo;
    }
}

