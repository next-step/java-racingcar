package carRacing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    Car car;

    @BeforeEach
    void SetUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    void movableTest(String input, String expected) {
        car.setRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(input);
            }
        });

        boolean movable = car.movable();

        assertThat(String.valueOf(movable)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void moveTest(String input, String expected) {
        car.setRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(input);
            }
        });

        car.move();

        assertThat(car.inquiryPosition()).isEqualTo(Integer.parseInt(expected));
    }
}
