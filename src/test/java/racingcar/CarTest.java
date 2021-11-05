package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    @DisplayName("move 메소드는 자동차를 확률적으로 이동시키고 현재 위치를 반환한다")
    public void 테스트_Car_move() {

        Car car = new Car();
        assertThat(car.move()).isGreaterThanOrEqualTo(0);
    }
}