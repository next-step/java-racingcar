package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.Fixture.*;

class CarTest {
    @BeforeEach
    void initCar() {
        car = new Car();
    }
    @Test
    @DisplayName("random 값이 4미만일 경우 움직일 수 없다.")
    void canNotMove() {
        int randomValue = 3;
        assertThat(car.tryMove(randomValue)).isEqualTo(stopped);
    }

    @Test
    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    void canMove() {
        int randomValue = 5;
        assertThat(car.tryMove(randomValue)).isEqualTo(distance);
    }
}