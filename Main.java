import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main{
public static void main(String[] args) {
    Calculadora calculadora = new Calculadora();
    String operacion = "";
    try {
        List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\mads4\\Documents\\Datos.txt"));
        if (!lineas.isEmpty()) {
            operacion = lineas.get(0);
            System.out.println("Operación: " + operacion);
        } else {
            System.out.println("El archivo está vacío.");
        }
        
        Scanner scanner = new Scanner(operacion);
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                calculadora.getStack().push(scanner.nextInt());
            }
            else {
                String operador = scanner.next();
                int operando2 = calculadora.getStack().pop();
                int operando1 = calculadora.getStack().pop();
                int resultado;
                switch (operador) {
                    case "+":
                        resultado = (operando1 + operando2);
                        calculadora.getStack().push(resultado);
                    break;
                    case "-":
                        resultado = (operando1 - operando2);
                        calculadora.getStack().push(resultado);
                        break;

                    case "*":
                        resultado = (operando1 * operando2);
                        calculadora.getStack().push(resultado);
                        break;
                    case "/":
                        if(operando2 == 0){
                            throw new IllegalArgumentException("No es posible hacer una división entre 0");
                        }
                        else{
                            resultado = (operando1/operando2);
                            calculadora.getStack().push(resultado);
                        }
                        break;
                    case "%":
                        resultado = (operando1%operando2);
                        calculadora.getStack().push(resultado);
                        break;
                    default:
                        throw new IllegalArgumentException("Ingrese un operando válido porfavor");
                }
            }
        }
        scanner.close();
        System.out.println("El resultado es: " + calculadora.getStack().peek());

    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    } catch (IllegalArgumentException e) {
        System.out.println("Error en la operación: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
    }
    }
}