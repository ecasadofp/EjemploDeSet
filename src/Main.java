public class Main {

    public static void main(String[] args) {
        //Cargamos datos iniciales

        Concesionario concComoNuevos = new Concesionario("Coches como nuevos", "Huesca", "974 23 45 67");
        Concesionario concBaratos = new Concesionario("Coches baratos", "Huesca", "974 22 33 44");
        Concesionario concSegundones = new Concesionario("Coches segundones campeones", "Jaca", "974 32 32 32");

        Coche coche1 = new Coche("Ford", "Focus", 130, 5000, "3333-GSF");
        Coche coche2 = new Coche("Renault", "Clio", 111, 2550.23, "4535-BDJ");
        Coche coche3 = new Coche("Lamborghini", "Gallardo", 530, 43500.3, "HU-3333-O");

        concBaratos.addCoche(coche1);
        concBaratos.addCoche(coche2);
        concBaratos.addCoche(coche3);

        //Mostramos los datos del concesionario Coches baratos
        System.out.println(concBaratos);

        // Mostramos los coches que valen menos de 10.000 € de Coches Baratos
        concBaratos.muestraMasBaratos(10000);

        //Vendemos coche1
        concBaratos.vendeCoche(coche1);
        System.out.println(concBaratos);

        //Vendemos el Lambo por matrícula
        concBaratos.vendeCoche("HU-3333-O");
        System.out.println(concBaratos);

        //Ahora intentamos añadir el coche2 que ya está, no dejará por repetido
        System.out.println(concBaratos);

        //Ahora intentamos añadir el mismo clio pero creando objeto nuevo. No debería dejar pero...
        concBaratos.addCoche(new Coche("Renault", "Clio", 111, 2550.23, "4535-BDJ"));
        System.out.println(concBaratos);

        //El problema es que comprueba el hash del objeto antes que el equals. Si el hash es diferente da por seguro que el hash también
        //hay que sobreescribir hashCode para que sea coherente

        //Si ahora hemos implementado la interfaz comparable en coche (y su compareTo) podemos cambiar a un treeSet y estará ordenado
        //por su orden natural que es por precio
        //Antes intentamos añadirle todos otra vez

        concBaratos.addCoche(coche1);
        concBaratos.addCoche(coche2);
        concBaratos.addCoche(coche3);

        concBaratos.muestraTodos();

    }

}
