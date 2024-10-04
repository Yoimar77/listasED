package ejecutables;

/**
 * Clase Nodo que representa un nodo en una lista enlazada.
 * 
 * @param <TipoDato> El tipo de dato que se almacenará en el nodo.
 */
public class Nodo<TipoDato> {
    private TipoDato dato;
    private Nodo<TipoDato> siguienteNodo;

    /**
     * Constructor que inicializa el nodo con un dato.
     *
     * @param dato El dato que almacena el nodo.
     */
    public Nodo(TipoDato dato) {
        this.dato = dato;
        this.siguienteNodo = null;  // El siguiente nodo es null al crear un nuevo nodo
    }

    public TipoDato getDato() {
        return dato;
    }

    public void setDato(TipoDato dato) {
        this.dato = dato;
    }

    public Nodo<TipoDato> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo<TipoDato> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                '}';
    }
}
