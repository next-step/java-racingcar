package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.movablestrategy.RandomStrategy;
import racingcar.movablestrategy.ParameterStrategy;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("자동차를 생성하면 초기 위치는 0 이다.")
    @Test
    void Car_초기위치() {
        Car car = new Car(new RandomStrategy(Car.MOVE_CONDITION, 10));
        assertThat(car.samePosition(0)).isTrue();
    }

    @DisplayName("자동차가 전진할수있다.")
    @Test
    void Car_전진() {
        Car car = new Car(new ParameterStrategy(Car.MOVE_CONDITION, Car.MOVE_CONDITION + 1));
        car.move();
        assertThat(car.samePosition(car.MOVE_DISTANCE)).isTrue();
    }

    @DisplayName("숫자가 이동 조건 보다 작다면 자동차는 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {Car.MOVE_CONDITION - 1, Car.MOVE_CONDITION - 2, Car.MOVE_CONDITION - 3})
    void Car_이동조건_미충족(int value) {
        Car car = new Car(new ParameterStrategy(Car.MOVE_CONDITION, value));
        car.move();
        assertThat(car.samePosition(Car.INITIAL_POSITION)).isTrue();
    }

    @DisplayName("숫자가 이동 조건 이상이라면 자동차는 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {Car.MOVE_CONDITION, Car.MOVE_CONDITION+2, Car.MOVE_CONDITION+3})
    void Car_이동조건_충족(int value) {
        Car car = new Car(new ParameterStrategy(Car.MOVE_CONDITION, value));
        car.move();
        assertThat(car.samePosition(Car.MOVE_DISTANCE)).isTrue();
    }
}
