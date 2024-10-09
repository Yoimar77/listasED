package lineales;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que representa una cola (queue) gen�rica usando nodos.
 *
 * @param <TipoDato> El tipo de dato que la cola almacenar�.
 */
public class Cola<TipoDato> implements Iterable<TipoDato> {
    private Nodo<TipoDato> nodoInicio;  // Nodo en el frente de la cola
    private Nodo<TipoDato> nodoFinal;    // Nodo al final de la cola
    private int tama�o;                  // Para llevar el tama�o de la cola

    public Cola() {
        this.nodoInicio = null;
        this.nodoFinal = null;
        this.tama�o = 0;
    }

    /**
     * M�todo para agregar un dato a la cola.
     *
     * @param dato El dato a agregar a la cola.
     */
    public void agregar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);

        if (nodoFinal != null) {
            nodoFinal.setSiguienteNodo(nuevoNodo); // Conectar el nuevo nodo al final
        }
        nodoFinal = nuevoNodo; // Actualizar el nodo final

        if (nodoInicio == null) {
            nodoInicio = nuevoNodo; // Si la cola estaba vac�a, el nuevo nodo es el frente
        }

        tama�o++;
    }

    /**
     * M�todo para eliminar y retornar el dato del frente de la cola.
     *
     * @return El dato del nodo en el frente de la cola.
     */
    public TipoDato sacar() {
        if (nodoInicio == null) {
            throw new NoSuchElementException("La cola est� vac�a.");
        }

        TipoDato dato = nodoInicio.getDato();
        nodoInicio = nodoInicio.getSiguienteNodo(); // Mover el frente a la siguiente posici�n

        if (nodoInicio == null) {
            nodoFinal = null; // Si la cola queda vac�a, actualizar el nodo final
        }

        tama�o--;
        return dato;
    }

    public int tama�o() {
        return tama�o;
    }

    @Override
    public Iterator<TipoDato> iterator() {
        return new IteradorCola();
    }

    /**
     * Iterador que recorre la cola en orden de inserci�n
     */
    private class IteradorCola implements Iterator<TipoDato> {
        private Nodo<TipoDato> actual = nodoInicio;  // Comienza desde el nodo frente

        @Override
        public boolean hasNext() {
            return actual != null; // Verificar si hay m�s elementos
        }

        @Override
        public TipoDato next() {
            if (actual == null) {
                throw new NoSuchElementException();
            }

            TipoDato dato = actual.getDato();
            actual = actual.getSiguienteNodo(); // Avanza al siguiente nodo
            return dato;
        }
    }
}