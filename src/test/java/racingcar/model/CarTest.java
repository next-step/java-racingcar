package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.Car.DEFAULT_POSITION;
import static racingcar.model.Car.RUNNING_CONDITION;
import static racingcar.model.CarValidator.NAME_LENGTH_LIMIT;

public class CarTest {


    @DisplayName("자동차를 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"name", "test1"})
    void createCarNameSuccess(String name) {
        Car car = Car.create(name);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @DisplayName(RUNNING_CONDITION + "이상이면 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void move(int power) {
        Car car = Car.create();

        int expected = DEFAULT_POSITION + car.getPosition();

        assertThat(car.move(power)).isEqualTo(expected);
    }

    @DisplayName(RUNNING_CONDITION + "보다 작으면 움직이지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveFail(int power) {
        Car car = Car.create();
        int expected = car.getPosition();
        assertThat(car.move(power)).isEqualTo(expected);
    }
}
