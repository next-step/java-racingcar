package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("처음 위치는 0이다")
    void initialPositionIsZero() {
        Car car = new Car();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("값이 4 이상이면 위치가 1 증가한다")
    void moveForwardIfNumberIsFourOrMore(int number) {
        Car car = new Car();

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("값이 3 이하면 위치가 그대로다")
    void stayIfNumberIsThreeOrLess(int number) {
        Car car = new Car();

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
