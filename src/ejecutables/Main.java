package ejecutables;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la lista enlazada
        ListaEnlazada<String> listaFacultades = new ListaEnlazada<>();

        // Agregar tres facultades a la lista
        listaFacultades.agregar("Facultad de Ingenier�a");
        listaFacultades.agregar("Facultad de Ciencias Econ�micas");
        listaFacultades.agregar("Facultad de Ciencias b�sicas");

        // Imprimir la lista utilizando un bucle for-each
        System.out.println("Imprimir la lista usando un bucle for-each:");
        for (String facultad : listaFacultades) {
            System.out.println(facultad);
        }

        // Imprimir la lista utilizando el m�todo imprimirLista()
        System.out.println("\nImprimir la lista usando el m�todo imprimirLista():");
        listaFacultades.imprimirLista();
        
        
        System.out.println("\nImprimir con el iterator propio de nuestra lista");
        Iterator iterador = listaFacultades.iterator();
        while(iterador.hasNext()) {
        	System.out.println(iterador.next());
        }
        
        // Imprimir el tama�o de la lista
        System.out.println("\nTama�o de la lista: " + listaFacultades.tama�o());
    }
}
