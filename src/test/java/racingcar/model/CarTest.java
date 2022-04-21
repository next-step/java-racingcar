package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.FixedFalseMovingStrategy;
import racingcar.strategy.FixedTrueMovingStrategy;
import racingcar.strategy.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("생성된 자동차 객체의 초기 위치 확인")
    void checkInitialPositionCreatedCarObject() {
        Car car = new Car(new RandomMovingStrategy(), "pobi");

        assertThat(car.getCurrentPosition()).isZero();
    }

    @Test
    @DisplayName("자동차가 위치가 변경된 후 결과 확인")
    void checkPositionMovedCar() {
        Car car = new Car(new FixedTrueMovingStrategy(), "pobi");
        car.move();
        assertThat(car.getCurrentPosition()).isOne();
    }

    @Test
    @DisplayName("자동차 위치가 변경되지 않는 경우")
    void checkPositionNotMovedCar() {
        Car car = new Car(new FixedFalseMovingStrategy(), "pobi");
        car.move();
        assertThat(car.getCurrentPosition()).isZero();
    }

    @ParameterizedTest
    @DisplayName("자동차 저장된 이름 확인")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void checkSavedNames(String value) {
        Car car = new Car(new FixedFalseMovingStrategy(), value);

        assertThat(car.getCarName()).isEqualTo(value);
    }
}
