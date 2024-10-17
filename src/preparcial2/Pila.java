package preparcial2;

import java.util.NoSuchElementException;

/**
 * Clase Pila que representa una pila gen�rica.
 *
 * @param <TipoDato> El tipo de dato que la pila almacenar�.
 */
public class Pila<TipoDato> {
    private Nodo<TipoDato> cima; // El nodo en la cima de la pila
    private int tama�o;          // Contador de elementos en la pila

    /**
     * Constructor de la clase Pila.
     * Inicializa la pila vac�a.
     */
    public Pila() {
        this.cima = null;
        this.tama�o = 0;
    }

    /**
     * M�todo para agregar un elemento a la cima de la pila.
     *
     * @param dato El dato a agregar a la pila.
     */
    public void agregar(TipoDato dato) {
        Nodo<TipoDato> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguienteNodo(cima);
        cima = nuevoNodo;
        tama�o++;
    }

    /**
     * M�todo para eliminar el elemento en la cima de la pila.
     *
     * @return El dato que fue eliminado de la cima.
     * @throws NoSuchElementException Si la pila est� vac�a.
     */
    public TipoDato sacar() {
        if (cima == null) {
            throw new NoSuchElementException("La pila est� vac�a");
        }
        TipoDato dato = cima.getDato();
        cima = cima.getSiguienteNodo();
        tama�o--;
        return dato;
    }

    /**
     * M�todo para obtener el tama�o actual de la pila.
     * 
     * @return El n�mero de elementos en la pila.
     */
    public int tama�o() {
        return tama�o;
    }
}
