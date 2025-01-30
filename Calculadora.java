import java.util.Scanner;

public class Calculadora{
    Stack<Integer> stack = new StackVector<Integer>();

    public Stack<Integer> getStack(){
        return stack;
    }

    public void setStack(Stack<Integer> stack){
        this.stack = stack;
    }
    
    public Calculadora(){    
    }
    
    public int Calculo(int operando1, int operando2, String operador){
        switch (operador) {
            case "+":
                return operando1 + operando2;
            case "-":
                return operando1 - operando2;

            case "*":
                return operando1*operando2;

            case "/":
                if(operando2 == 0){
                    throw new IllegalArgumentException("No es posible hacer una división entre 0");
                }
                else{
                    return operando1/operando2;
                }
            case "%":
                return operando1%operando2;
            default:
                throw new IllegalArgumentException("Ingrese un operando válido porfavor");
        }
    }

    public int Resultado(String problema){
        Scanner scanner = new Scanner(problema);
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                stack.push(scanner.nextInt());
            } else {
                String operador = scanner.next();
                int operando2 = stack.pop();
                int operando1 = stack.pop();    
                int resultado = Calculo(operando1, operando2, operador);
                stack.push(resultado);
            }
        }
        scanner.close();
        return stack.peek();
    }

}   