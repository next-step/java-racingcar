package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.Car.RUNNING_CONDITION;

public class CarTest {

    @DisplayName("자동차를 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"name", "test1"})
    void createCarNameSuccess(String name) {
        Car car = Car.create(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName(RUNNING_CONDITION + "이상이면 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void move(int power) {
        Car car = createCar();
        Position move = car.move(power);
        assertThat(move).isEqualTo(Position.valueOf(2));
    }

    @DisplayName(RUNNING_CONDITION + "보다 작으면 움직이지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveFail(int power) {
        Car car = createCar();
        assertThat(car.move(power)).isEqualTo(Position.valueOf(1));
    }

    public static Car createCar() {
        return Car.create("test1");
    }
}
