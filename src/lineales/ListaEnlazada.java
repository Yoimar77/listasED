package lineales;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que representa una lista enlazada gen�rica.
 *
 * @param <TipoDato> El tipo de dato que la lista almacenar�.
 */
public class ListaEnlazada<TipoDato> implements Iterable<TipoDato> {
    private Nodo<TipoDato> nodoInicio;  // El primer nodo de la lista
    private Nodo<TipoDato> nodoFinal;   // El �ltimo nodo de la lista (opcional)

    /**
     * Constructor de la clase ListaEnlazada.
     * Inicializa la lista vac�a, con el nodo inicial como null.
     */
    public ListaEnlazada() {
        this.nodoInicio = null;
        this.nodoFinal = null;
    }

    /**
     * M�todo para agregar un dato a la lista enlazada.
     * Si la lista est� vac�a, se agrega como primer nodo.
     * Si no est� vac�a, se a�ade al final de la lista.
     *
     * @param dato El dato a agregar a la lista.
     */
    public void agregar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);  // Crea un nuevo nodo con el dato

        if (nodoInicio == null) {
            // Si la lista est� vac�a, el nuevo nodo es el nodo inicial
            nodoInicio = nuevoNodo;
            nodoFinal = nuevoNodo;
        } else {
            // Si la lista no est� vac�a, se agrega al final
            nodoFinal.setSiguienteNodo(nuevoNodo);
            nodoFinal = nuevoNodo;  // Actualizar el nodo final
        }
    }

    /**
     * M�todo para obtener el tama�o de la lista.
     * @return El n�mero de elementos en la lista.
     */
    public int tama�o() {
        int contador = 0;
        Nodo<TipoDato> puntero = nodoInicio;
        while (puntero != null) {
            contador++;
            puntero = puntero.getSiguienteNodo();
        }
        return contador;
    }

    /**
     * M�todo que imprime todos los elementos de la lista enlazada.
     */
    public void imprimirLista() {
        Nodo<TipoDato> puntero = nodoInicio;
        while (puntero != null) {
            System.out.println(puntero.getDato());
            puntero = puntero.getSiguienteNodo();
        }
    }

    /**
     * Implementaci�n del m�todo iterator() para poder recorrer la lista
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
         * Verifica si hay m�s elementos en la lista.
         *
         * @return true si hay m�s elementos, false si no.
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
                throw new NoSuchElementException();  // Si no hay m�s elementos
            }
            TipoDato dato = actual.getDato();
            actual = actual.getSiguienteNodo();  // Avanza al siguiente nodo
            return dato;
        }
    }
}

