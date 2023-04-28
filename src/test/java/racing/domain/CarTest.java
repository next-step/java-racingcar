package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Position;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void carRaceErrorTest(int randomNumber) {
        Car car = new Car("test");
        assertThatThrownBy(()->car.race(randomNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "3, 0", "4, 1", "9, 1"})
    void carRaceTest(int randomNumber, int expectedPosition) {
        Car car = new Car("test");
        assertThat(car.race(randomNumber).getPosition()).isEqualTo(new Position(expectedPosition));
    }
}
