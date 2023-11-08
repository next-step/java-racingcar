package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carRacing.CarRacing;
import study.carRacing.ReceiveInputValue;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    private static ReceiveInputValue receiveInputValue;

    @BeforeAll
    static void init() {
        receiveInputValue = new ReceiveInputValue();
    }

    @Test
    @DisplayName("receive a value for the number of car.")
    void receiveInputValueForCar() {

        String input = "3";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        int numberOfCar = receiveInputValue.receiveInputValueForCar();
        assertThat(numberOfCar).isEqualTo(3);
    }
}
