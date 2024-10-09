package lineales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que representa una pila (stack) genérica usando nodos.
 *
 * @param <TipoDato> El tipo de dato que la pila almacenará.
 */
public class Pila<TipoDato> implements Iterable<TipoDato> {
    private Nodo<TipoDato> nodoTope; // Nodo en el tope de la pila
    private int tamaño;               // Para llevar el tamaño de la pila

    public Pila() {
        this.nodoTope = null;
        this.tamaño = 0;
    }

    public void apilar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);
        
        if (nodoTope == null) {
            // Si la pila está vacía, el nuevo nodo es el tope
            nodoTope = nuevoNodo;
        } else {
            // El nuevo nodo se convierte en el nuevo tope de la pila
            nuevoNodo.setSiguienteNodo(nodoTope);
            nodoTope = nuevoNodo;
        }
        tamaño++;
    }

    public TipoDato desapilar() {
        if (nodoTope == null) {
            throw new NoSuchElementException("La pila está vacía.");
        }

        TipoDato dato = nodoTope.getDato();
        nodoTope = nodoTope.getSiguienteNodo();
        
        tamaño--;
        return dato;
    }

    public int tamaño() {
        return tamaño;
    }

    @Override
    public Iterator<TipoDato> iterator() {
        return new IteradorPila();
    }

    /**
     * Iterador que recorre la pila en orden de inserción
     */
    private class IteradorPila implements Iterator<TipoDato> {
        private final ArrayList<TipoDato> elementos; // Lista para almacenar elementos en orden de inserción
        private int indice; // Índice para la lista de elementos

        public IteradorPila() {
            this.elementos = new ArrayList<>();
            // Almacena todos los elementos de la pila en la lista
            Nodo<TipoDato> nodoRecorriendo = nodoTope;
            while (nodoRecorriendo != null) {
                elementos.add(nodoRecorriendo.getDato());
                nodoRecorriendo = nodoRecorriendo.getSiguienteNodo(); // Avanza al siguiente nodo
            }
            Collections.reverse(elementos); // Invierte para que esté en el orden correcto
            this.indice = 0; // Inicializa el índice
        }

        @Override
        public boolean hasNext() {
            return indice < elementos.size(); // Verifica si hay más elementos
        }

        @Override
        public TipoDato next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elementos.get(indice++); // Retorna el siguiente elemento y avanza el índice
        }
    }
}
