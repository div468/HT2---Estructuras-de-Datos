import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(); // Usa la ruta predeterminada
        
        try {
            // Leer la operación del archivo
            String operacion = calculadora.leerArchivo();
            System.out.println("Operación leída del archivo: " + operacion);

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
//que