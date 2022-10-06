package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차의 시작 위치는 0이다")
    void initPosition() {
        assertThat(new Car("차").getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 시도 성공 시 position이 1 위치로 변경된다")
    void go_success() {
        Car car = new Car("차", () -> true);
        car.go();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 시도 실패시 움직이지 않는다")
    void go_fail() {
        Car car = new Car("차", () -> false);
        car.go();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 11})
    @DisplayName("모든 이동 성공 시 성공한 횟수가 위치와 동일하다")
    void go_success_repeat(int repeat) {
        Car car = new Car("차", () -> true);
        for (int i = 0; i < repeat; i++) {
            car.go();
        }

        assertThat(car.getPosition()).isEqualTo(repeat);
    }
}
