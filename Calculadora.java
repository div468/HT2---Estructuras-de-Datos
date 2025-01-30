/**
* @Project : HT2 - Algoritmos y Estructuras de Datos
* @author Julián Divas
* Creacion 28.01.2025
* Ultima modificacion 30.01.2025
* @FileName: Calculadora.java
*/


//Se importan los recursos necesarios
import java.util.Scanner;

//Clase calculadora a realizar
public class Calculadora implements Interfaz{
    //Stack utilizado como ADT de la calculadora
    private Stack<Integer> stack;

    //Get correspondiente del atributo
    /**
     * @return El stack con el que trabaja la calculadora
     */
    public Stack<Integer> getStack(){
        return stack;
    }

    //Set correspondiente del atributo
    /**
     * @param stack el stack a asignar a la calculadora
     */
    public void setStack(Stack<Integer> stack){
        this.stack = stack;
    }

    
    /**
     * Constructor de la clase
     */
    public Calculadora(){
        this.stack = new StackVector<Integer>();
    }

    //Método reestructurado de la interfaz
    @Override
    public int operar(int operando1, int operando2, String operador){
        //En base al parametro recibido, se elige que operación matemática se realizará y se lleva a cabo
        switch (operador) {
            case "+":
                //Se suman los operandos
                return operando1 + operando2;
            case "-":
                //Se restan los operandos
                return operando1 - operando2;

            case "*":
                //Se multiplican los operandos
                return operando1*operando2;

            case "/":
                //Se hacen verificaciones para no llevar a cabo divisiones entre 0
                if(operando2 == 0){
                    throw new IllegalArgumentException("No es posible hacer una división entre 0");
                }
                else{
                    //Se dividen los operandos
                    return operando1/operando2;
                }
            case "%":
                //Se encuentra el módulo entre los operandos
                return operando1%operando2;
            default:
                //Se verifica que el argumento ingresado sea válido
                throw new IllegalArgumentException("Ingrese un operando válido porfavor");
        }
    }

    @Override
    public int evaluar(String problema) {
        //Se utiliza un Scanner para analizar la operación matemática recibida como parámetro
        Scanner scanner = new Scanner(problema);
        try {
            //Mientras exista un siguiente caracter en el programa
            while (scanner.hasNext()) {
                //Si el siguiente caracter es un entero
                if (scanner.hasNextInt()) {
                    //Se añade al stack
                    stack.push(scanner.nextInt());
                } else {
                    //Si no es un entero, se obtiene el operador correspondiente
                    String operador = scanner.next();
                    //Se verifica que existan los suficientes operandos para realizar una operación matemática
                    if (stack.size() < 2) {
                        //Si no los hay se muestra un error
                        throw new IllegalStateException("Expresión inválida: faltan operandos para '" + operador + "'");
                    }
                    //Se obtienen los operandos anteriormente añadidos al stack
                    int operando2 = stack.pop();
                    int operando1 = stack.pop();
                    //Los operandos y el operador son trabajados en el método operar para obtener el resultado correcto
                    int resultado = operar(operando1, operando2, operador);
                    //Se inserta el resultado en el stackvector nuevamente
                    stack.push(resultado);
                }
            }

            //Se verifica que no existan operadores sobrantes
            if (stack.size() > 1) {
                throw new IllegalStateException("Expresión inválida: hay operadores de más.");
            }

            //Se devuelve el resultado final
            return stack.pop();

        } finally {
            //Se cierra el scanner
            scanner.close();
        }
    }
}   