package preparcial2;

import java.util.NoSuchElementException;

/**
 * Clase Pila que representa una pila genérica.
 *
 * @param <TipoDato> El tipo de dato que la pila almacenará.
 */
public class Pila<TipoDato> {
    private Nodo<TipoDato> cima; // El nodo en la cima de la pila
    private int tamaño;          // Contador de elementos en la pila

    /**
     * Constructor de la clase Pila.
     * Inicializa la pila vacía.
     */
    public Pila() {
        this.cima = null;
        this.tamaño = 0;
    }

    /**
     * Método para agregar un elemento a la cima de la pila.
     *
     * @param dato El dato a agregar a la pila.
     */
    public void agregar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguienteNodo(cima);
        cima = nuevoNodo;
        tamaño++;
    }

    /**
     * Método para eliminar el elemento en la cima de la pila.
     *
     * @return El dato que fue eliminado de la cima.
     * @throws NoSuchElementException Si la pila está vacía.
     */
    public TipoDato sacar() {
        if (cima == null) {
            throw new NoSuchElementException("La pila está vacía");
        }
        TipoDato dato = cima.getDato();
        cima = cima.getSiguienteNodo();
        tamaño--;
        return dato;
    }

    /**
     * Método para obtener el tamaño actual de la pila.
     * 
     * @return El número de elementos en la pila.
     */
    public int tamaño() {
        return tamaño;
    }
}
