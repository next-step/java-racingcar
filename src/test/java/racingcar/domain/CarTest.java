package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("move 호출 마다 자동차 위치 증가")
    @Test
    void move() {
        Car car = new Car();
        int moveCount = 3;

        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.position()).isEqualTo(moveCount);
    }
}
