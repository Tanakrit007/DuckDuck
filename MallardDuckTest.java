import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MallardDuckTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private MallardDuck mallardDuck;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        mallardDuck = new MallardDuck();
    }

    @Test
    public void testConstructor() {
        assertTrue(mallardDuck.flyBehavior instanceof FlyWithWings, "MallardDuck should have FlyWithWings behavior");
        assertTrue(mallardDuck.quackBehavior instanceof Quack, "MallardDuck should have Quack behavior");
    }

    @Test
    public void testDisplay() {
        mallardDuck.display();
        assertEquals("I'm a real Mallard duck\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testPerformFly() {
        mallardDuck.performFly();
        assertEquals("I'm flying!!\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testPerformQuack() {
        mallardDuck.performQuack();
        assertEquals("Quack\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testSwim() {
        mallardDuck.swim();
        assertEquals("All ducks float, even decoys!\n", outContent.toString().replace("\r\n", "\n"));
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
