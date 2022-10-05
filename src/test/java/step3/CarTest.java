package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private final Car car = new Car();
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void Test() {
        car.race();
        assertEquals("-\n", outContent.toString());
    }
}
