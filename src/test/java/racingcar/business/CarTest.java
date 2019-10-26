package racingcar.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = Car.of(CarName.get(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void moveAndGetDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            car.move();
        }
        int result = car.getTotalDistance();
        assertThat(result).isEqualTo(distance);
    }
}
