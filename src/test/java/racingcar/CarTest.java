package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차의 시작 위치는 0이다")
    void initPosition() {
        assertThat(new Car().getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("이동을 시도했을 때 확률에 따라 움직이거나, 움직이지 않는다")
    void go() {
        Car car = new Car();
        car.go();

        assertThat(car.getPosition())
                .isBetween(0, 1);
    }
}
