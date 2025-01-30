/**
* @Project : HT2 - Algoritmos y Estructuras de Datos
* @author Julián Divas
* Creacion 28.01.2025
* Ultima modificacion 30.01.2025
* @FileName: Main.java
*/

//Se importan los recursos necesarios
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

//Clase Principal del programa
public class Main {
    //Método principal
    public static void main(String[] args) {
        //Se inicializa la calculadora correspondiente
        Calculadora calculadora = new Calculadora();
        //Se da la bienvenida y solicita que ingresen la ruta del archivo txt
        System.out.println("Bienvenido a su calculadora");
        System.out.println("Por favor, ingrese la ruta en donde se encuentra el archivo datos.txt");

        //Se inicia un scanner para recibir la ruta del archivo
        Scanner scanner = new Scanner(System.in);
        //Se guarda la ruta
        String ruta = scanner.nextLine();
        //Se cierra el scanner
        scanner.close();

        try {
            //Se lee el archivo en la ruta específicada
            List<String> lineas = Files.readAllLines(Paths.get(ruta));

            //Si hay lineas vacias
            if (lineas.isEmpty()) {
                //Se muestra un aviso
                System.out.println("El archivo está vacío.");
                return;
            }

            //Para cada operacion en las lineas
            for (String operacion : lineas) {
                //Se verffica que la linea no esté vacía
                if (!operacion.trim().isEmpty()) {
                    //Se muestra la operación correspondiente
                    System.out.println("Operación: " + operacion);
                    try {
                        //Se llama al método evaluar de la calculadora para obtener el resultado correcto
                        int resultado = calculadora.evaluar(operacion);
                        //Se muestra el resultado correcto al usuario
                        System.out.println("El resultado de la operación es: " + resultado);
                    } catch (IllegalArgumentException e) {
                        //Se manejan distintos errores
                        System.out.println("Error en la operación: " + e.getMessage());
                    }
                }
            }
        //Se manejan distintos errores
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
