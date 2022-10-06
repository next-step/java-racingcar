package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 이동 가능 테스트")
    void moveTest() {
        Car car = new Car("내 자동차");
        car.moveOrStop(() -> true);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이동 불가능 테스트")
    void notMoveTest() {
        Car car = new Car("내 자동차");
        car.moveOrStop(() -> false);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}