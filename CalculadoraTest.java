import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    // Este método se ejecuta antes de cada prueba para inicializar la calculadora.
    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // Prueba de la operación de suma.
    @Test
    void testSuma() {
        // Se verifica que la suma de 3 + 5 sea igual a 8
        assertEquals(8, calculadora.operar(3, 5, "+"), "3 + 5 debe ser 8");
    }

    // Prueba de la operación de resta.
    @Test
    void testResta() {
        // Se verifica que la resta de 10 - 4 sea igual a 6
        assertEquals(6, calculadora.operar(10, 4, "-"), "10 - 4 debe ser 6");
    }

    // Prueba de la operación de multiplicación.
    @Test
    void testMultiplicacion() {
        // Se verifica que la multiplicación de 6 * 7 sea igual a 42
        assertEquals(42, calculadora.operar(6, 7, "*"), "6 * 7 debe ser 42");
    }

    // Prueba de la operación de división.
    @Test
    void testDivision() {
        // Se verifica que la división de 20 / 4 sea igual a 5
        assertEquals(5, calculadora.operar(20, 4, "/"), "20 / 4 debe ser 5");
    }

    // Prueba de división por cero (debe lanzar una excepción).
    @Test
    void testDivisionPorCero() {
        // Se verifica que al intentar dividir entre 0, se lance una excepción
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.operar(10, 0, "/");
        });
        // Se verifica que el mensaje de la excepción sea el esperado
        assertEquals("No es posible hacer una división entre 0", exception.getMessage());
    }

    // Prueba de la operación de módulo.
    @Test
    void testModulo() {
        // Se verifica que el módulo de 10 % 3 sea igual a 1
        assertEquals(1, calculadora.operar(10, 3, "%"), "10 % 3 debe ser 1");
    }

    // Prueba cuando se pasa un operador inválido.
    @Test
    void testOperadorInvalido() {
        // Se verifica que al pasar un operador no válido (^) se lance una excepción
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.operar(10, 5, "^");
        });
        // Se verifica que el mensaje de la excepción sea el esperado
        assertEquals("Ingrese un operando válido porfavor", exception.getMessage());
    }

    // Prueba de una expresión completa usando la función evaluar().
    @Test
    void testResultadoExpresionCompleta() {
        // Se verifica que la expresión '10 5 + 3 *' sea evaluada correctamente, debe dar 45
        assertEquals(45, calculadora.evaluar("10 5 + 3 *"), "La expresión '10 5 + 3 *' debe dar 45");
    }
}
