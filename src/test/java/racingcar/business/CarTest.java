package racingcar.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of(CarName.get(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void raceAndGetDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            car.race();
        }
        int result = car.getTotalDistance();
        assertThat(result).isLessThanOrEqualTo(distance);
    }

    @ParameterizedTest
    @ValueSource(ints = {100})
    void isEnableToMove(int count) {
        for (int i = 0; i < count; i++) {
            double randomValue = Math.random();
            int result = (int) (randomValue * 10);

            assertThat(result).isGreaterThanOrEqualTo(0);
            assertThat(result).isLessThan(10);
        }
    }

    @Test
    void race() {

    }

}
