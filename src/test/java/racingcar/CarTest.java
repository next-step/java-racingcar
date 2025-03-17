package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차는_경기_play_횟수를_알_수_있다() {
        Car car = new Car();
        assertThat(car.play()).isGreaterThanOrEqualTo(0);
        assertThat(car.getPlayCount()).isEqualTo(1);
    }

    @Test
    void 자동차의_전진한_거리가_0_또는_양수의_숫자로_리턴된다() {
        Car car = new Car();
        assertThat(car.getDistance()).isGreaterThanOrEqualTo(0);
    }
}