package Lazo;

import java.util.*;

public class GestorMatriz {

    public static Paquete<Integer>[][] crear(int zonas, int paquetesPorZona) {
        return new Paquete[zonas][paquetesPorZona];
    }

    public static void llenar(Paquete<Integer>[][] m, List<Paquete<Integer>> lista) {

        int[] cont = new int[m.length];

        for (Paquete<Integer> p : lista) {
            int z = p.zona - 1;
            m[z][cont[z]++] = p;
        }
    }

    public static void mostrar(Paquete<Integer>[][] m) {

        for (int i = 0; i < m.length; i++) {

            System.out.println("\nZona " + (i + 1));

            for (int j = 0; j < m[i].length; j++) {
                System.out.println(m[i][j]);
            }
        }
    }
}