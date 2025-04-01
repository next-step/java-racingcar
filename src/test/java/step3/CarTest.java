package step3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("각 자동차의 랜덤 값의 전진/멈춤 조건에 따라 true/false를 moveHistory에 저장한다")
    @Test
    void saveMoveHistory() {
        Car car = new Car();
        car.move();

        assertThat(car.findMoveAt(0)).isIn(true, false);
    }
}