package preparcial2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        // Agregar elementos
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        //Agrega elelemento en un ïndice específico
        lista.agregar(1, 15);
 
        ArrayList <Integer> array = new ArrayList<>();
        array.add(40);
        array.add(50);
        // Agregar todos los elementos de una colección
        lista.agregarTodos(array);
       
        //Recorrer la lista con el iterator
        Iterator iterador = lista.iterator();
        while(iterador.hasNext()) {
       	 System.out.println(iterador.next());
        }
        //Obtenemos el tamaño
        System.out.println("\nTamaño: " + lista.obtenerTamaño());

        //Elimina elemento en una posición específica
        lista.eliminar(0);

        //Obtene elemento
        System.out.println("Elemento en índice 0: " + lista.obtener(0));

        // Reemplazar elemento
        lista.set(0, 100);
 

        //Invertir la lista
        lista.reversar();
        System.out.println("Lista invertida:");
        Iterator iterador2 = lista.iterator();
        while(iterador2.hasNext()) {
       	 System.out.println(iterador2.next());
        }
    }
}

