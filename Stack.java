public interface Stack<E> 
{
   /**
    * @param item el objeto a trabajar en el stack
    */
   public void push(E item);
   // pre: 
   // post: item is added to stack
   // will be popped next if no intervening push
   
   /**
    * @return el valor más próximo en el stack
    */
   public E pop();
   // pre: stack is not empty
   // post: most recently pushed item is removed and returned
   
   /**
    * @return el valor más proximo en el stack
    */
   public E peek();
   // pre: stack is not empty
   // post: top value (next to be popped) is returned
   
   /**
    * @return verdadero o falso dependiendo si el stack está vacío o no
    */
   public boolean empty();
   // post: returns true if and only if the stack is empty
   
   /**
    * @return el tamaño del stack
    */
   public int size();
   // post: returns the number of elements in the stack

}