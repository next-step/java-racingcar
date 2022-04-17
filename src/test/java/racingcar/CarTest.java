package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {
    @Test
    @DisplayName("자동차를 생성하면 초기 위치는 0이다.")
    void 자동차를_생성하면_DISTANCE는_0이다 () {
        Car car = new Car();
        assertThat(car.getDistance()).isZero();
    }

    @Test
    @DisplayName("자동차가 4 이상의 숫자를 받으면 움직인다.")
    void move_test() {
        Car car = new Car();
        car.play(4);
        car.play(3);
        car.play(3);

        assertThat(car.getDistance()).isEqualTo(1);
        assertThat(car.getDistance()).isEqualTo(1);

    }
}
