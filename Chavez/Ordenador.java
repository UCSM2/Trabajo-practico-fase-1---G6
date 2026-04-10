package Chavez;

import Lazo.Paquete;

public class Ordenador {

    public static void insertionSort(Paquete<Integer>[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Paquete<Integer> key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].prioridad < key.prioridad) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
    
    public static void quickSort(Paquete<Integer>[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Paquete<Integer>[] arr, int low, int high) {

        Paquete<Integer> pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].prioridad >= pivot.prioridad) {
                i++;

                Paquete<Integer> temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Paquete<Integer> temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}