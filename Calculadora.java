import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Calculadora{
    Stack<Integer> stack = new StackVector<Integer>();
    private String archivoRuta;
    
    public Calculadora(String archivoRuta) {
        this.archivoRuta = archivoRuta;
    }
    public Calculadora() {
    }
    
    public String leerArchivo() throws IOException {
        FileReader reader = new FileReader(archivoRuta);
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

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora("C:\\Users\\mads4\\Desktop\\Datos.txt"); // Usa la ruta predeterminada
        try {
            // Leer la operación del archivo
            String operacion = calculadora.leerArchivo();
            System.out.println("Operacion leída del archivo: " + operacion);

            // Calcular el resultado
            int resultado = calculadora.Resultado(operacion);
            System.out.println("El resultado de la operación es: " + resultado);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la operación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}   