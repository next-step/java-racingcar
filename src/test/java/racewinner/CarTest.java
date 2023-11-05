package racewinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차가 이동 할 때, 이동에 성공하면 위치가 1 증가한다.")
    @Test
    void moveTest() {
        // given
        final Car car = new Car("simpson", () -> true);

        // when
        car.move();

        // then
        assertThat(car.currentStep()).isEqualTo(1);
    }

    @DisplayName("자동차가 이동 할 때, 이동에 실패하면 위치는 증가하지 않는다.")
    @Test
    void stopTest() {
        // given
        final Car car = new Car("simpson", () -> false);

        // when
        car.move();

        // then
        assertThat(car.currentStep()).isEqualTo(0);
    }
}