import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackVectorTest {

    private StackVector<Integer> stack;

    // Este método se ejecuta antes de cada prueba para inicializar el stack.
    @BeforeEach
    void setUp() {
        stack = new StackVector<>();
    }

    // Prueba de la operación push() y size().
    @Test
    void testPush() {
        stack.push(10);
        stack.push(20);
        
        // Verificamos que el tamaño del stack sea 2 después de hacer push de dos elementos.
        assertEquals(2, stack.size(), "El tamaño del stack debe ser 2 después de hacer push de dos elementos.");
    }

    // Prueba de la operación pop().
    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);
        
        // Verificamos que el último elemento añadido es el primero en ser eliminado (último en entrar, primero en salir).
        assertEquals(20, stack.pop(), "El valor devuelto por pop() debe ser 20.");
        
        // Verificamos que después de hacer pop, el tamaño del stack sea 1.
        assertEquals(1, stack.size(), "El tamaño del stack debe ser 1 después de hacer pop.");
    }

    // Prueba de la operación peek().
    @Test
    void testPeek() {
        stack.push(10);
        stack.push(20);
        
        // Verificamos que peek() devuelve el último valor agregado sin eliminarlo.
        assertEquals(20, stack.peek(), "El valor devuelto por peek() debe ser 20.");
        
        // Verificamos que el tamaño del stack no se modifica después de llamar a peek().
        assertEquals(2, stack.size(), "El tamaño del stack no debe cambiar después de llamar a peek().");
    }

    // Prueba de la operación empty().
    @Test
    void testEmpty() {
        // Al principio el stack debe estar vacío.
        assertTrue(stack.empty(), "El stack debe estar vacío inicialmente.");
        
        stack.push(10);
        
        // Después de hacer push, el stack ya no debe estar vacío.
        assertFalse(stack.empty(), "El stack no debe estar vacío después de hacer push.");
        
        stack.pop();
        
        // Después de hacer pop, el stack debe estar vacío de nuevo.
        assertTrue(stack.empty(), "El stack debe estar vacío después de hacer pop.");
    }

    // Prueba de la excepción al intentar hacer pop en un stack vacío.
    @Test
    void testPopEmptyStack() {
        // Intentamos hacer pop en un stack vacío y esperamos una excepción.
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        }, "Pop en un stack vacío debe lanzar una excepción.");
    }

    // Prueba de la operación size() en un stack vacío.
    @Test
    void testSizeEmptyStack() {
        // Verificamos que el tamaño del stack vacío sea 0.
        assertEquals(0, stack.size(), "El tamaño de un stack vacío debe ser 0.");
    }
}
