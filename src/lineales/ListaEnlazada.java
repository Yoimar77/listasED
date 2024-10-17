package lineales;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que representa una lista enlazada genérica.
 *
 * @param <TipoDato> El tipo de dato que la lista almacenará.
 */
public class ListaEnlazada<TipoDato> implements Iterable<TipoDato> {
    private Nodo<TipoDato> nodoInicio;  // El primer nodo de la lista
    private Nodo<TipoDato> nodoFinal;   // El último nodo de la lista (opcional)

    /**
     * Constructor de la clase ListaEnlazada.
     * Inicializa la lista vacía, con el nodo inicial como null.
     */
    public ListaEnlazada() {
        this.nodoInicio = null;
        this.nodoFinal = null;
    }

    /**
     * Método para agregar un dato a la lista enlazada.
     * Si la lista está vacía, se agrega como primer nodo.
     * Si no está vacía, se añade al final de la lista.
     *
     * @param dato El dato a agregar a la lista.
     */
    public void agregar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);  // Crea un nuevo nodo con el dato

        if (nodoInicio == null) {
            // Si la lista está vacía, el nuevo nodo es el nodo inicial
            nodoInicio = nuevoNodo;
            nodoFinal = nuevoNodo;
        } else {
            // Si la lista no está vacía, se agrega al final
            nodoFinal.setSiguienteNodo(nuevoNodo);
            nodoFinal = nuevoNodo;  // Actualizar el nodo final
        }
    }

    /**
     * Método para obtener el tamaño de la lista.
     * @return El número de elementos en la lista.
     */
    public int tamaño() {
        int contador = 0;
        Nodo<TipoDato> puntero = nodoInicio;
        while (puntero != null) {
            contador++;
            puntero = puntero.getSiguienteNodo();
        }
        return contador;
    }

    /**
     * Método que imprime todos los elementos de la lista enlazada.
     */
    public void imprimirLista() {
        Nodo<TipoDato> puntero = nodoInicio;
        while (puntero != null) {
            System.out.println(puntero.getDato());
            puntero = puntero.getSiguienteNodo();
        }
    }

    /**
     * Implementación del método iterator() para poder recorrer la lista
     * utilizando un bucle for-each o directamente con un Iterator.
     *
     * @return Un Iterator sobre los elementos de la lista.
     */
    @Override
    public Iterator<TipoDato> iterator() {
        return new IteradorListaEnlazada();
    }

    /**
     * Clase interna que implementa el Iterator para recorrer la lista enlazada.
     */
    private class IteradorListaEnlazada implements Iterator<TipoDato> {
        private Nodo<TipoDato> actual = nodoInicio;  // Comienza desde el nodo inicial

        /**
         * Verifica si hay más elementos en la lista.
         *
         * @return true si hay más elementos, false si no.
         */
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        /**
         * Retorna el siguiente elemento de la lista.
         *
         * @return El siguiente elemento de la lista.
         */
        @Override
        public TipoDato next() {
            if (actual == null) {
                throw new NoSuchElementException();  // Si no hay más elementos
            }
            TipoDato dato = actual.getDato();
            actual = actual.getSiguienteNodo();  // Avanza al siguiente nodo
            return dato;
        }
    }
}

