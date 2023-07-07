package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차는 이름을 가질 수 있다")
    @Test
    void 자동차_이름_있음() {
        assertThatNoException()
                .isThrownBy(() -> new Car(""));

    }

    @DisplayName("주어진 힘이 4 이상이면 자동차는 1만큼 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 자동차_전진(int power) {
        Car car = new Car("", 0);

        car.move(power);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("주어진 힘이 3 이하면 자동차는 정지한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 자동차_정지(int power) {
        Car car = new Car("");

        car.move(power);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
