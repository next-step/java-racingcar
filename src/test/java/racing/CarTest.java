package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @DisplayName("Car move() method test")
    @CsvSource(value = {"1,1", "10,10"})
    void move(int input, int expected) {
        Car car = new Car();
        for (int i = 0; i < input; i++) {
            car.move();
        }
        assertThat(car.valueOfCurrentPosition()).isEqualTo(expected);
    }
}
