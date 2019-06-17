package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.Car.DEFAULT_POSITION;
import static racingcar.model.Car.RUNNING_CONDITION;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.create();
    }

    @DisplayName(RUNNING_CONDITION + "이상이면 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void move(int power) {
        int expected = DEFAULT_POSITION + car.getPosition();
        assertThat(car.move(power)).isEqualTo(expected);
    }

    @DisplayName(RUNNING_CONDITION + "보다 작으면 움직이지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveFail(int power) {
        int expected = car.getPosition();
        assertThat(car.move(power)).isEqualTo(expected);
    }
}
