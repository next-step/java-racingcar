package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.domain.Car;

public class CarTest {
    @DisplayName("자동차는 이름을 가진다.")
    @Test
    void hasName() {
        final Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    @Test
    void racingInputLengthErrorTest() {
        assertThatThrownBy(() -> {
            new Car("November");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 초기 위치는 0이다.")
    @Test
    void showInitPosition() {
        final Car car = new Car("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    @Test
    void getCurrentPosition() {
        Car car = new Car("june", 10);
        assertThat(car.getPosition()).isEqualTo(10);
    }

    @DisplayName("자동차가 4 이상일 때 전진한다.")
    @ValueSource(ints = {4,5,6,7,8,9})
    @ParameterizedTest
    void move(int input) {
        Car car = new Car("june");
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 4 미만일 때 정지한다.")
    @ValueSource(ints = {0,1,2,3})
    @ParameterizedTest
    void stop(int input) {
        Car car = new Car("june");
        car.move(input);
        assertThat(car.getPosition()).isZero();
    }
}
