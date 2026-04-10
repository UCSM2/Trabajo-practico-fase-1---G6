package Calle;

import java.io.*;
import java.util.*;
import Lazo.Paquete;

public class LectorArchivo {

    public static int capacidad, zonas, paquetesPorZona;

    public static List<Paquete<Integer>> leer(String archivo) throws Exception {

        List<Paquete<Integer>> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea;

        while ((linea = br.readLine()) != null) {

            linea = linea.trim();

            if (linea.isEmpty()) continue; 

            if (linea.startsWith("CAPACIDAD")) {
                capacidad = Integer.parseInt(linea.split("=")[1]);
            } 
            else if (linea.startsWith("ZONAS")) {
                zonas = Integer.parseInt(linea.split("=")[1]);
            } 
            else if (linea.startsWith("PAQUETES_POR_ZONA")) {
                paquetesPorZona = Integer.parseInt(linea.split("=")[1]);
            } 
            else if (linea.toLowerCase().startsWith("codigo")) {
                continue; 
            } 
            else if (linea.contains(",")) {

                String[] d = linea.split(",");

               
                if (!d[1].matches("\\d+")) continue;

                lista.add(new Paquete<>(
                    d[0],
                    Integer.parseInt(d[1]),
                    convertir(d[2]),
                    Integer.parseInt(d[3]),
                    Integer.parseInt(d[4])
                ));
            }
        }

        br.close();
        return lista;
    }

    private static int convertir(String p) {
        if (p.equalsIgnoreCase("Alta")) return 3;
        if (p.equalsIgnoreCase("Media")) return 2;
        return 1;
    }
}