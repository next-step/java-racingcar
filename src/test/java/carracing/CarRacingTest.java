package carracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static carracing.CarRacing.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void move() {
        Car car = new Car();
        car.move();
        String result = car.distance();
        assertThat(result).isEqualTo("-");
    }

    @Test
    void random() {
        Car car = new Car();
        assertThat(car.random()).isLessThanOrEqualTo(9);
        assertThat(car.random()).isGreaterThanOrEqualTo(0);
    }
}