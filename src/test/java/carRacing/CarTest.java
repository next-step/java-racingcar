package carRacing;


import carRacing.Domain.Car;
import carRacing.Domain.MoveRandom;
import carRacing.Domain.MoveStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    void movableTest(String input, String expected) {
        MoveStrategy moveRandom = new MoveRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(input);
            }
        });

        assertThat(String.valueOf(moveRandom.movable())).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void moveTest(String input, String expected) {
        MoveStrategy moveRandom = new MoveRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(input);
            }
        });
        Car car = new Car(moveRandom);

        car.move();

        assertThat(car.inquiryPosition()).isEqualTo(Integer.parseInt(expected));
    }
}
