package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차가 1회 전진한다.")
    void moveForward_전진() {
        Car car = new Car();
        car.moveForward(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 정지한다.")
    void moveForward_정지() {
        Car car = new Car();
        car.moveForward(() -> false);

        assertThat(car.getPosition()).isEqualTo(0);
    }


    @Test
    @DisplayName("자동차들의 현재 위치값을 비교할 수 있다")
    void compareTo_위치값비교() {
        Car car_forward = new Car();
        Car car_backward = new Car();

        car_forward.moveForward(() -> true);
        car_backward.moveForward(() -> false);

        assertThat(car_forward).isGreaterThan(car_backward);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("레이스를 진행하고 우승자를 찾을 수 있다.")
    void isWinner(int winnerPosition, boolean expected) {
        Car car = new Car();
        IntStream.range(0, 3)
                .forEach(i -> car.moveForward(() -> true));

        assertThat(car.isWinner(winnerPosition)).isEqualTo(expected);
    }
}