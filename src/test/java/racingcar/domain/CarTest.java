package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @Test
    void move() {
        Car car = new Car();

        car.move(new MovingStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        });

        assertThat(car.getCarStateInString()).isEqualTo("Unknown : -");
    }

    @Test
    void equals() {
        assertThat(new Car("A", 3).equals(new Car("A", 3))).isEqualTo(true);
        assertThat(new Car("B", 4).equals(new Car("B", 5))).isEqualTo(false);
        assertThat(new Car("C", 5).equals(new Car("D", 5))).isEqualTo(false);
    }
}
