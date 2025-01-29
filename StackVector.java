
import java.util.Vector;

public class StackVector<E> implements Stack<E> {
    protected Vector <E> datos;

    public StackVector(){
        datos = new Vector<E>();
    }
    public void push (E item){
        // pre: 
        // post: item is added to stack
        // will be popped next if no intervening push
        datos.add(item);
    }

    public E pop() {
        // pre: stack is not empty
        // post: most recently pushed item is removed and returned
        return datos.remove(size()-1);
    }

    public E peek() {
        // pre: stack is not empty
        // post: top value (next to be popped) is returned
        return datos.get(size()-1);
    }

    public int size(){
        // post: returns true if and only if the stack is empty
        return datos.size();
    }

    public boolean empty(){
        // post: returns the number of elements in the stack
        return datos.size() == 0;
    }
}