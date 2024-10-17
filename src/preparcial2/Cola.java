package preparcial2;

import java.util.NoSuchElementException;

/**
 * Clase Cola que representa una cola genérica.
 *
 * @param <TipoDato> El tipo de dato que la cola almacenará.
 */
public class Cola<TipoDato> {
    private Nodo<TipoDato> nodoInicio;  // El primer nodo de la cola
    private Nodo<TipoDato> nodoFinal;   // El último nodo de la cola
    private int tamaño;                 // Contador de elementos en la cola

    /**
     * Constructor de la clase Cola.
     * Inicializa la cola vacía.
     */
    public Cola() {
        this.nodoInicio = null;
        this.nodoFinal = null;
        this.tamaño = 0;
    }

    /**
     * Método para agregar un elemento a la cola.
     *
     * @param dato El dato a agregar a la cola.
     */
    public void agregar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);
        if (nodoFinal != null) {
            nodoFinal.setSiguienteNodo(nuevoNodo);
        }
        nodoFinal = nuevoNodo;
        if (nodoInicio == null) {
            nodoInicio = nuevoNodo; // Si la cola estaba vacía, el nuevo nodo es también el inicio
        }
        tamaño++;
    }

    /**
     * Método para eliminar el último elemento de la cola.
     * 
     * @return El dato que fue eliminado.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    public TipoDato eliminar() {
        if (nodoInicio == null) {
            throw new NoSuchElementException("La cola está vacía");
        }
        TipoDato dato = nodoInicio.getDato();
        nodoInicio = nodoInicio.getSiguienteNodo();
        tamaño--;
        if (nodoInicio == null) {
            nodoFinal = null; // Si la cola queda vacía, también se resetea el nodo final
        }
        return dato;
    }

    /**
     * Método para eliminar el elemento en la posición indicada por el parámetro.
     *
     * @param indice La posición del elemento a eliminar.
     * @return El dato que fue eliminado.
     * @throws NoSuchElementException Si la cola está vacía o el índice es inválido.
     */
    public TipoDato eliminar(int indice) {
        if (nodoInicio == null || indice < 0 || indice >= tamaño) {
            throw new NoSuchElementException("Índice inválido o la cola está vacía");
        }
        if (indice == 0) {
            return eliminar(); // Si se desea eliminar el primer elemento
        }

        Nodo<TipoDato> puntero = nodoInicio;
        for (int i = 0; i < indice - 1; i++) {
            puntero = puntero.getSiguienteNodo();
        }
        TipoDato dato = puntero.getSiguienteNodo().getDato();
        puntero.setSiguienteNodo(puntero.getSiguienteNodo().getSiguienteNodo());
        if (puntero.getSiguienteNodo() == null) {
            nodoFinal = puntero; // Actualiza el nodo final si se elimina el último elemento
        }
        tamaño--;
        return dato;
    }

    /**
     * Método para obtener el elemento en la cabecera de la cola sin eliminarlo.
     *
     * @return El dato en la cabecera, o null si la cola está vacía.
     */
    public TipoDato vistazo() {
        return (nodoInicio != null) ? nodoInicio.getDato() : null;
    }

    /**
     * Método para obtener el tamaño actual de la cola.
     * 
     * @return El número de elementos en la cola.
     */
    public int tamaño() {
        return tamaño;
    }
}

