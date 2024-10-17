package preparcial2;

import java.util.NoSuchElementException;

/**
 * Clase Cola que representa una cola gen�rica.
 *
 * @param <TipoDato> El tipo de dato que la cola almacenar�.
 */
public class Cola<TipoDato> {
    private Nodo<TipoDato> nodoInicio;  // El primer nodo de la cola
    private Nodo<TipoDato> nodoFinal;   // El �ltimo nodo de la cola
    private int tama�o;                 // Contador de elementos en la cola

    /**
     * Constructor de la clase Cola.
     * Inicializa la cola vac�a.
     */
    public Cola() {
        this.nodoInicio = null;
        this.nodoFinal = null;
        this.tama�o = 0;
    }

    /**
     * M�todo para agregar un elemento a la cola.
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
            nodoInicio = nuevoNodo; // Si la cola estaba vac�a, el nuevo nodo es tambi�n el inicio
        }
        tama�o++;
    }

    /**
     * M�todo para eliminar el �ltimo elemento de la cola.
     * 
     * @return El dato que fue eliminado.
     * @throws NoSuchElementException Si la cola est� vac�a.
     */
    public TipoDato eliminar() {
        if (nodoInicio == null) {
            throw new NoSuchElementException("La cola est� vac�a");
        }
        TipoDato dato = nodoInicio.getDato();
        nodoInicio = nodoInicio.getSiguienteNodo();
        tama�o--;
        if (nodoInicio == null) {
            nodoFinal = null; // Si la cola queda vac�a, tambi�n se resetea el nodo final
        }
        return dato;
    }

    /**
     * M�todo para eliminar el elemento en la posici�n indicada por el par�metro.
     *
     * @param indice La posici�n del elemento a eliminar.
     * @return El dato que fue eliminado.
     * @throws NoSuchElementException Si la cola est� vac�a o el �ndice es inv�lido.
     */
    public TipoDato eliminar(int indice) {
        if (nodoInicio == null || indice < 0 || indice >= tama�o) {
            throw new NoSuchElementException("�ndice inv�lido o la cola est� vac�a");
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
            nodoFinal = puntero; // Actualiza el nodo final si se elimina el �ltimo elemento
        }
        tama�o--;
        return dato;
    }

    /**
     * M�todo para obtener el elemento en la cabecera de la cola sin eliminarlo.
     *
     * @return El dato en la cabecera, o null si la cola est� vac�a.
     */
    public TipoDato vistazo() {
        return (nodoInicio != null) ? nodoInicio.getDato() : null;
    }

    /**
     * M�todo para obtener el tama�o actual de la cola.
     * 
     * @return El n�mero de elementos en la cola.
     */
    public int tama�o() {
        return tama�o;
    }
}

