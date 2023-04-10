package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "3, 4"})
    void carMoveTest(int moveCount, int expectedPosition) {
        Car car = new Car();
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        assertThat(car.valueOfCurrentPosition()).isEqualTo(expectedPosition);
    }
}
