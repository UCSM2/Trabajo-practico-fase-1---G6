package Main;

import Calle.LectorArchivo;
import Lazo.*;
import Chavez.Ordenador;
import Torres.Mochila;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Paquete<Integer>> lista = LectorArchivo.leer("datos.txt");

        int zonas = LectorArchivo.zonas;
        int pz = LectorArchivo.paquetesPorZona;
        int cap = LectorArchivo.capacidad;

        Paquete<Integer>[][] matriz = GestorMatriz.crear(zonas, pz);
        GestorMatriz.llenar(matriz, lista);

     
        System.out.println("=== MATRIZ ORIGINAL ===");
        GestorMatriz.mostrar(matriz);

       
        for (int i = 0; i < zonas; i++) {
            Ordenador.insertionSort(matriz[i]);
        }

        System.out.println("\n=== ORDENADO (Insertion Sort) ===");
        GestorMatriz.mostrar(matriz);

       
        for (int i = 0; i < zonas; i++) {
            Ordenador.quickSort(matriz[i], 0, matriz[i].length - 1);
        }

        System.out.println("\n=== ORDENADO (Quick Sort) ===");
        GestorMatriz.mostrar(matriz);

        
        List<Paquete<Integer>> todos = new ArrayList<>();

        for (Paquete<Integer>[] fila : matriz) {
            todos.addAll(Arrays.asList(fila));
        }

        int[] peso = new int[todos.size()];
        int[] valor = new int[todos.size()];

        for (int i = 0; i < todos.size(); i++) {
            peso[i] = todos.get(i).peso;
            valor[i] = todos.get(i).valorizacion;
        }

        int max = Mochila.resolver(peso, valor, cap);

     
        System.out.println("\n=== RESULTADO MOCHILA ===");
        System.out.println("Valorización máxima: " + max);
    }
}
