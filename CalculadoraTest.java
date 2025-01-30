import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void testSuma() {
        assertEquals(8, calculadora.operar(3, 5, "+"), "3 + 5 debe ser 8");
    }

    @Test
    void testResta() {
        assertEquals(6, calculadora.operar(10, 4, "-"), "10 - 4 debe ser 6");
    }

    @Test
    void testMultiplicacion() {
        assertEquals(42, calculadora.operar(6, 7, "*"), "6 * 7 debe ser 42");
    }

    @Test
    void testDivision() {
        assertEquals(5, calculadora.operar(20, 4, "/"), "20 / 4 debe ser 5");
    }

    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.operar(10, 0, "/");
        });
        assertEquals("No es posible hacer una división entre 0", exception.getMessage());
    }

    @Test
    void testModulo() {
        assertEquals(1, calculadora.operar(10, 3, "%"), "10 % 3 debe ser 1");
    }

    @Test
    void testOperadorInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.operar(10, 5, "^");
        });
        assertEquals("Ingrese un operando válido porfavor", exception.getMessage());
    }

    @Test
    void testResultadoExpresionCompleta() {
        assertEquals(45, calculadora.evaluar("10 5 + 3 *"), "La expresión '10 5 + 3 *' debe dar 45");
    }
}