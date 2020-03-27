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

        String result = String.valueOf(moveRandom.movable());

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "3:1", "4:2", "9:2"}, delimiter = ':')
    void moveTest(String input, String expected) {
        MoveStrategy moveRandom = new MoveRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(input);
            }
        });
        Car car = new Car("player", moveRandom);

        car.move();
        int result = car.inquiryPosition();

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }
}
