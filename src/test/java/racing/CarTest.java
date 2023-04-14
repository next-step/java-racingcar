package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "3, 0", "4, 1", "9, 1"})
    void carRaceTest(int randomNumber, int expectedPosition) {
        Car car = new Car();
        car.race(randomNumber);
        assertThat(car.valueOfCurrentPosition()).isEqualTo(expectedPosition);
    }
}
