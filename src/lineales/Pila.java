package lineales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que representa una pila (stack) gen�rica usando nodos.
 *
 * @param <TipoDato> El tipo de dato que la pila almacenar�.
 */
public class Pila<TipoDato> implements Iterable<TipoDato> {
    private Nodo<TipoDato> nodoTope; // Nodo en el tope de la pila
    private int tama�o;               // Para llevar el tama�o de la pila

    public Pila() {
        this.nodoTope = null;
        this.tama�o = 0;
    }

    public void apilar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);
        
        if (nodoTope == null) {
            // Si la pila est� vac�a, el nuevo nodo es el tope
            nodoTope = nuevoNodo;
        } else {
            // El nuevo nodo se convierte en el nuevo tope de la pila
            nuevoNodo.setSiguienteNodo(nodoTope);
            nodoTope = nuevoNodo;
        }
        tama�o++;
    }

    public TipoDato desapilar() {
        if (nodoTope == null) {
            throw new NoSuchElementException("La pila est� vac�a.");
        }

        TipoDato dato = nodoTope.getDato();
        nodoTope = nodoTope.getSiguienteNodo();
        
        tama�o--;
        return dato;
    }

    public int tama�o() {
        return tama�o;
    }

    @Override
    public Iterator<TipoDato> iterator() {
        return new IteradorPila();
    }

    /**
     * Iterador que recorre la pila en orden de inserci�n
     */
    private class IteradorPila implements Iterator<TipoDato> {
        private final ArrayList<TipoDato> elementos; // Lista para almacenar elementos en orden de inserci�n
        private int indice; // �ndice para la lista de elementos

        public IteradorPila() {
            this.elementos = new ArrayList<>();
            // Almacena todos los elementos de la pila en la lista
            Nodo<TipoDato> nodoRecorriendo = nodoTope;
            while (nodoRecorriendo != null) {
                elementos.add(nodoRecorriendo.getDato());
                nodoRecorriendo = nodoRecorriendo.getSiguienteNodo(); // Avanza al siguiente nodo
            }
            Collections.reverse(elementos); // Invierte para que est� en el orden correcto
            this.indice = 0; // Inicializa el �ndice
        }

        @Override
        public boolean hasNext() {
            return indice < elementos.size(); // Verifica si hay m�s elementos
        }

        @Override
        public TipoDato next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elementos.get(indice++); // Retorna el siguiente elemento y avanza el �ndice
        }
    }
}
