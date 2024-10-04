package ejecutables;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la lista enlazada
        ListaEnlazada<String> listaFacultades = new ListaEnlazada<>();

        // Agregar tres facultades a la lista
        listaFacultades.agregar("Facultad de Ingeniería");
        listaFacultades.agregar("Facultad de Ciencias Económicas");
        listaFacultades.agregar("Facultad de Ciencias básicas");

        // Imprimir la lista utilizando un bucle for-each
        System.out.println("Imprimir la lista usando un bucle for-each:");
        for (String facultad : listaFacultades) {
            System.out.println(facultad);
        }

        // Imprimir la lista utilizando el método imprimirLista()
        System.out.println("\nImprimir la lista usando el método imprimirLista():");
        listaFacultades.imprimirLista();
        
        
        System.out.println("\nImprimir con el iterator propio de nuestra lista");
        Iterator iterador = listaFacultades.iterator();
        while(iterador.hasNext()) {
        	System.out.println(iterador.next());
        }
        
        // Imprimir el tamaño de la lista
        System.out.println("\nTamaño de la lista: " + listaFacultades.tamaño());
    }
}
