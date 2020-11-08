package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @DisplayName("Car 이동하기")
    @ValueSource(ints = {0, 1, 2})
    void move(int movementExpected) {
        Cars cars = new Cars(carNames);

        cars.move(() -> movementExpected);

        assertThat(cars.getCarList())
                .extracting(Car::getPosition)
                .allMatch((position) -> position == Car.INITIAL_POSITION + movementExpected);
    }
}
