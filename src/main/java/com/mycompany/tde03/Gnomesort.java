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

    public Gnomesort(){this.numSwap=0;this.numIteracoes=0;}

    public int[] Sort(int[] a) {
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
        return a;
    }

    public long getNumSwap(){
        return this.numSwap;
    }

    public int getNumIteracoes() {
        return numIteracoes;
    }
}

