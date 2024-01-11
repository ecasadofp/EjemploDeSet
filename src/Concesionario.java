import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Concesionario {

    String nombre;
    String ciudad;

    String telefono;
    TreeSet<Coche> coches;

    public Concesionario(String nombre, String ciudad, String telefono) {

        this.nombre = nombre;
        this.ciudad = ciudad;
        this.coches = new TreeSet<>();
    }

    /**
     * Asigna un coche al concesionario para su venta
     * @param coche El coche que se añade al concesionario
     */

    public void addCoche(Coche coche){

        coches.add(coche);

    }

    /**
     * Elimina el coche indicado de la colección, si existe
     * @param coche El coche a eliminar
     * @return true si lo ha eliminado y false si no
     */
    public boolean vendeCoche(Coche coche){
        return coches.remove(coche);
    }


    /**
     * Elimina el coche con la matrícula indicada de la colección, si existe
     * @param matricula La matricula del coche a eliminar de la colección
     * @return true si había un coche con esa matrícula y false si no se ha encontrado
     */
    public boolean vendeCoche(String matricula){

        Iterator<Coche> it = coches.iterator();

        while (it.hasNext()){

            Coche c = it.next();
            if(c.getMatricula().equals(matricula)){
                it.remove();
                return true;
            }

        }
            return false;
    }

    /**
     * Muestra coches del concesionario hasta un precio de referencia
     * @param precio Precio de referencia
     */
    public void muestraMasBaratos(double precio){
        System.out.printf("Coches del concesionario con precios hasta %.2f €", precio);
        System.out.println();
        System.out.println();
        for(Coche c:coches){
            if(c.getPrecio()<=precio)
                System.out.println(c);

        }
    }
    public void muestraTodos(){
        for(Coche c:coches)
            System.out.println(c);
    }



    @Override
    public String toString() {

        String salida = "Nombre: " + nombre + "\nCiudad: " + ciudad + "\nCoches en stock: " + coches.size();
        return salida;
    }

}
