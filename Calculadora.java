import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Calculadora{
    Stack<Integer> stack = new StackVector<Integer>();
    public String leerArchivo(String direccion) throws IOException{
            FileReader reader = new FileReader(direccion);
            BufferedReader lectura = new BufferedReader(reader);
            String operacion = lectura.readLine();
            lectura.close();
            return operacion;
            }
    
    public int Calculo(int operando2, int operando1, String operador){
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
                int resultado = Calculo(operando2, operando1, operador);
                stack.push(resultado);
            }
        }
        scanner.close();
        return stack.peek();
    }
}   