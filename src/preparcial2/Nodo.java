package preparcial2;
/**
 * Clase Nodo que representa un nodo en una lista enlazada.
 *
 * @param <TipoDato> El tipo de dato que el nodo almacenará.
 */
public class Nodo<TipoDato> {
    private TipoDato dato;          // Dato almacenado en el nodo
    private Nodo<TipoDato> siguienteNodo; // Referencia al siguiente nodo

    /**
     * Constructor de la clase Nodo.
     *
     * @param dato El dato a almacenar en el nodo.
     */
    public Nodo(TipoDato dato) {
        this.dato = dato;
        this.siguienteNodo = null; // Inicialmente, el siguiente nodo es nulo
    }

    /**
     * Método para obtener el dato del nodo.
     *
     * @return El dato almacenado en el nodo.
     */
    public TipoDato getDato() {
        return dato;
    }

    /**
     * Método para establecer un nuevo dato en el nodo.
     *
     * @param dato El nuevo dato a almacenar en el nodo.
     */
    public void setDato(TipoDato dato) {
        this.dato = dato;
    }

    /**
     * Método para obtener el siguiente nodo.
     *
     * @return El siguiente nodo.
     */
    public Nodo<TipoDato> getSiguienteNodo() {
        return siguienteNodo;
    }

    /**
     * Método para establecer el siguiente nodo.
     *
     * @param siguienteNodo El nuevo nodo siguiente.
     */
    public void setSiguienteNodo(Nodo<TipoDato> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}


