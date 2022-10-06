package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

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
    @DisplayName("car_race_동작_테스트")
    public void race_test() {
        car.race();
        assertEquals("-\n", outContent.toString());
    }
}
