/**
 * @author enrique.casado@fppiramide.com
 * @version 11/01/2024
 */
public class Coche implements Comparable<Coche> {

    private String marca;
    private String modelo;
    private int cv;
    private double precio;
    private String matricula;

    public Coche(String marca, String modelo, int cv, double precio, String matricula) {

        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.precio = precio;
        this.matricula = matricula;

    }

    public double getPrecio() {
        return precio;
    }

    public String getMatricula() {
        return matricula;
    }


    @Override
    public int compareTo(Coche c) {
        if (this.precio == c.precio)
            return 0;
        if (this.precio < c.precio)
            return -1;
        return 1;
    }

    @Override
    public int hashCode() {
        return this.matricula.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Coche))
            return false;

        Coche co = (Coche) o;
        if (this.matricula.equals(co.matricula))
            return true;

        return false;
    }

    @Override
    public String toString() {
        String salida = String.format("Marca: %s, modelo: %s, %d caballos, %s, %.2f precio", marca, modelo, cv, matricula, precio);
        return salida;
    }


}
