package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("자동차가 이동하는 값이 4 이상일 경우 전진하는지 확인")
    @ValueSource(strings = {"yun"})
    void carMovesWhenFourOrMore(String name) {
        Car car = new Car(name);
        car.move(4);
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 이동하는 값이 4 이하일 경우 멈춰있는지 확인")
    @ValueSource(strings = {"yun"})
    void carStopWhenLessThanFour(String name) {
        Car car = new Car(name);
        car.move(3);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"longName"})
    @DisplayName("자동차 이름이 5글자 이상인 경우 에러를 반환하는지 확인")
    void carNameThrowsExceptionWhenTooLong(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5 미만의 글자여야 합니다.");
    }

    @Test
    @DisplayName("가장 많은 거리를 간 자동차를 우승자로 반환하는지 확인")
    void findWinner() {
        Car testCar1 = new Car("yun1", 3);
        Car testCar2 = new Car("yun2", 2);
        Car testCar3 = new Car("yun3", 1);
        List<Car> cars = Arrays.asList(testCar1, testCar2, testCar3);

        List<Car> winners = Winners.findWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).contains(testCar1);
    }

}
