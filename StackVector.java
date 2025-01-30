/**
* @Project : HT2 - Algoritmos y Estructuras de Datos
* @author Julián Divas
* Creacion 28.01.2025
* Ultima modificacion 28.01.2025
* @FileName: StackVector.java
*/
//Se importa la clase vector
import java.util.Vector;

//Clase StackVector
public class StackVector<E> implements Stack<E> {
    //Vector donde se guardará la información
    protected Vector <E> datos;

    
    /**
     * Construcror correspondiente de la clase
     */
    public StackVector(){
        datos = new Vector<E>();
    }

    /**
     * @param item el objeto a añadir al stack
     */
    public void push (E item){
        // pre: 
        // post: item is added to stack
        // will be popped next if no intervening push
        datos.add(item);
    }

    /**
     * @return el item más reciente del stack
     */
    public E pop() {
        // pre: stack is not empty
        // post: most recently pushed item is removed and returned
        return datos.remove(size()-1);
    }

    /**
     * @return el item más reciente del stack
     */
    public E peek() {
        // pre: stack is not empty
        // post: top value (next to be popped) is returned
        return datos.get(size()-1);
    }

    /**
     * @return el tamaño del stack
     */
    public int size(){
        // post: returns the number of elements in the stack
        return datos.size();
    }

    /**
     * @return verdadero si el stack está vacío o falso si no lo está.
     */
    public boolean empty(){
        // post: returns true if and only if the stack is empty
        return datos.size() == 0;
    }
}