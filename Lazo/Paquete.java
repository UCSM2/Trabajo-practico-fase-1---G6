package Lazo;

public class Paquete<T extends Comparable<T>> {
    public String codigo;
    public int peso;
    public T prioridad;
    public int valorizacion;
    public int zona;

    public Paquete(String c, int p, T pr, int v, int z) {
        codigo = c;
        peso = p;
        prioridad = pr;
        valorizacion = v;
        zona = z;
    }

    @Override
    public String toString() {
        return codigo + " | Peso: " + peso +
               " | Prioridad: " + prioridad +
               " | Valor: " + valorizacion +
               " | Zona: " + zona;
    }
}