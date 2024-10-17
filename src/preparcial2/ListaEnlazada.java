package preparcial2;

import java.util.Collection;
import java.util.Iterator;

public class ListaEnlazada<T> implements Iterable<T> {
    private Nodo<T> inicio; // Referencia al inicio de la lista
    private int tama�o; // Tama�o de la lista

    public ListaEnlazada() {
        this.inicio = null;
        this.tama�o = 0;
    }

    // M�todo para agregar un elemento al final de la lista
    public void agregar(T elemento) {
        if (inicio == null) {
            inicio = new Nodo<>(elemento);
        } else {
            Nodo<T> actual = inicio;
            while (actual.getSiguienteNodo() != null) {
                actual = actual.getSiguienteNodo();
            }
            actual.setSiguienteNodo(new Nodo<>(elemento));
        }
        tama�o++;
    }

    // M�todo para agregar un elemento en una posici�n espec�fica
    public void agregar(int indice, T elemento) {
        if (indice < 0 || indice > tama�o) {
            throw new IndexOutOfBoundsException("�ndice fuera de rango");
        }

        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (indice == 0) {
            nuevoNodo.setSiguienteNodo(inicio);
            inicio = nuevoNodo;
        } else {
            Nodo<T> actual = inicio;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getSiguienteNodo();
            }
            nuevoNodo.setSiguienteNodo(actual.getSiguienteNodo());
            actual.setSiguienteNodo(nuevoNodo);
        }
        tama�o++;
    }

    // M�todo para agregar todos los elementos de una colecci�n
    public void agregarTodos(Collection<? extends T> col) {
        for (T elemento : col) {
            agregar(elemento);
        }
    }

    // M�todo para eliminar el �ltimo elemento de la lista
    public void eliminar() {
        if (inicio == null) {
            throw new IllegalStateException("La lista est� vac�a");
        }

        if (inicio.getSiguienteNodo() == null) {
            inicio = null;
        } else {
            Nodo<T> actual = inicio;
            while (actual.getSiguienteNodo().getSiguienteNodo() != null) {
                actual = actual.getSiguienteNodo();
            }
            actual.setSiguienteNodo(null);
        }
        tama�o--;
    }

    // M�todo para eliminar un elemento en una posici�n espec�fica
    public void eliminar(int indice) {
        if (indice < 0 || indice >= tama�o) {
            throw new IndexOutOfBoundsException("�ndice fuera de rango");
        }

        if (indice == 0) {
            inicio = inicio.getSiguienteNodo();
        } else {
            Nodo<T> actual = inicio;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getSiguienteNodo();
            }
            actual.setSiguienteNodo(actual.getSiguienteNodo().getSiguienteNodo());
        }
        tama�o--;
    }

    // M�todo para obtener el elemento en una posici�n espec�fica
    public T obtener(int indice) {
        if (indice < 0 || indice >= tama�o) {
            throw new IndexOutOfBoundsException("�ndice fuera de rango");
        }

        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguienteNodo();
        }
        return actual.getDato(); // Usar getDato() para acceder al dato
    }

    // M�todo para obtener el tama�o de la lista
    public int obtenerTama�o() {
        return tama�o;
    }

    // M�todo para invertir la lista
    public void reversar() {
        Nodo<T> anterior = null;
        Nodo<T> actual = inicio;
        Nodo<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.getSiguienteNodo();
            actual.setSiguienteNodo(anterior);
            anterior = actual;
            actual = siguiente;
        }
        inicio = anterior;
    }

    // M�todo para reemplazar un elemento en una posici�n espec�fica
    public void set(int indice, T elemento) {
        if (indice < 0 || indice >= tama�o) {
            throw new IndexOutOfBoundsException("�ndice fuera de rango");
        }

        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguienteNodo();
        }
        actual.setDato(elemento); // Usar setDato() para establecer el dato
    }

    // Implementaci�n del iterador
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    // Clase interna que implementa el iterador
    private class IteradorLista implements Iterator<T> {
        private Nodo<T> actual = inicio;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No hay m�s elementos");
            }
            T dato = actual.getDato(); // Usar getDato() para acceder al dato
            actual = actual.getSiguienteNodo();
            return dato;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operaci�n no soportada");
        }
    }
}
