/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;

import java.util.Random;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author otaku
 */
public class CountingSort {

    private long troca;
    private long iteracoes;
    private long tempoExe;
    private final int[] tamanhos;
    private final int[] seeds;
    private final int size;
    private final int[][] listas;

    public CountingSort(int[] tamanhos, int[] seeds, int size) {
        this.troca = 0;
        this.iteracoes = 0;
        this.tempoExe = 0;
        this.tamanhos = tamanhos;
        this.seeds = seeds;
        this.size = size;
        this.listas = new int[size][];
    }

    public void gerarDados(int tamanho) {
        for (int i = 0; i < this.size; i++) {
            Random random = new Random(seeds[i]);
            int[] lista = new int[tamanho];
            for (int l = 0; l < tamanho; l++) {
                lista[l] = random.nextInt(10000000);
            }
            this.listas[i] = lista;
        }
    }

    public void sort(DefaultCategoryDataset tempo, DefaultCategoryDataset dados) {
        for (int tamanho : tamanhos) {
            this.troca = 0;
            this.iteracoes = 0;
            this.tempoExe = 0;
            gerarDados(tamanho);
            for (int[] lista : listas) {
                long comeco = System.nanoTime();
                sort(lista, tamanho);
                long fim = System.nanoTime();
                this.tempoExe += fim - comeco;
            }
            this.tempoExe = this.tempoExe / this.size;
            this.troca = this.troca / this.size;
            this.iteracoes = this.iteracoes / this.size;
            resultados(tamanho, tempo, dados);
        }
    }
    
    public int maiorValor(int[] lista, int tamanho) {
        int maior = lista[0];
        
        for (int i = 1; i < tamanho; i++) {
            if (lista[i] > maior) {
                maior = lista[i];
            }
        }
        
        return maior;
    }
    
    public void sort(int[] lista, int tamanho) {
        int maior = maiorValor(lista,tamanho);
        int[] contador = new int[maior + 1];
        for (int valor : lista) {
            this.iteracoes++;
            contador[valor]++;
        }

        int index = 0;
        for (int i = 0; i < maior; i++) {
            while (contador[i] > 0) {
                lista[index++] = i;
                contador[i]--;
                this.troca++;
            }
        }
    }


    public void resultados(int tamanho, DefaultCategoryDataset tempo, DefaultCategoryDataset dados){
        long nanoSegundos = (this.tempoExe)%1000;
        long microSegundos = (this.tempoExe / 1000) % 1000;
        long miliSegundos = (this.tempoExe / 1000000);

        // Formatar tempo final como uma string
        String tempoFinal = String.format("%02d:%02d:%03d", miliSegundos, microSegundos, nanoSegundos);
        System.out.println("-----CountingSort - Tamanho:" + tamanho+"-----");
        System.out.println("Numero total de trocas: " + this.troca);
        System.out.println("Numero total de iteracoes: " + this.iteracoes);
        System.out.println("Tempo de execucao: " + tempoFinal);
        
        tempo.addValue(miliSegundos,"CountingSort",Integer.toString(tamanho));
        dados.addValue(this.troca,"Troca",Integer.toString(tamanho));
        dados.addValue(this.iteracoes,"Iterações",Integer.toString(tamanho));
    }

}
