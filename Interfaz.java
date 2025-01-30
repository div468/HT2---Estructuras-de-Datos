/**
* @Project : HT2 - Algoritmos y Estructuras de Datos
* @author Julián Divas
* Creacion 30.01.2025
* Ultima modificacion 30.01.2025
* @FileName: Interfaz.java
*/
public interface Interfaz{
    
    /**
     * @param operacion //String que representa la notación postfix de la operación matemática
     * @return El resultado de la operación matemática recibida como parámetro
     */
    int evaluar(String operacion);

    /**
     * @param operandoA //Numero entero a utilizar en una operacion matemática
     * @param operandoB //Numero entero a utilizar en una operacion matemática
     * @param operador Signo matemático que dicta si se realizará una suma, resta, etc.
     * @return el resultado de la operación matemática entre el operador A y el Operador B
     */
    int operar(int operandoA, int operandoB, String operador);

}