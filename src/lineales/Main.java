package lineales;

import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    	
        // Creamos una instancia de ListaEnlazada
        ListaEnlazada<String> listaFacultades = new ListaEnlazada<>();

        // Agregar tres facultades a la lista
        listaFacultades.agregar("Facultad de Ingeniería");
        listaFacultades.agregar("Facultad de Ciencias Económicas");
        listaFacultades.agregar("Facultad de Ciencias básicas");


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
        
    	//Creamos una instancia de Pila
    	Pila<String> pila = new Pila<String>();
    	pila.apilar("Primero en entrar");
    	pila.apilar("Segundo en entrar");
    	pila.apilar("Tercero en entrar");
    	
    	Iterator iterador2 = pila.iterator();
    	while(iterador2.hasNext()) {
    		System.out.println(iterador2.next());
    	}
    	//Aplicamos el método desapilar
    	System.out.println(pila.desapilar());
    	System.out.println(pila.desapilar());
    	
    	//Creamos una instancia de de Cola
    	Cola<Integer> cola = new Cola<Integer>();
    	cola.agregar(1);
    	cola.agregar(2);
    	cola.agregar(3);
    	
    	Iterator iterador3 = cola.iterator();
    	while(iterador3.hasNext()) {
    		System.out.println(iterador3.next());
    	}
    	
    	//Aplicamos el método sacar
    	System.out.println(cola.sacar());
    	System.out.println(cola.sacar());
    	
    	
    	
    	
    }
}
