package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("항상 성공하는 전략 주입시 position 증가")
    @Test
    public void movePossible() {
        Car car = new Car(() -> true, "test");
        assertThat(car.moveIfPossible()).isEqualTo(1);
        assertThat(car.moveIfPossible()).isEqualTo(2);
    }

    @DisplayName("항상 성공하는 전략 주입시 position 유지")
    @Test
    public void moveImpossible() {
        Car car = new Car(() -> false, "test");
        assertThat(car.moveIfPossible()).isEqualTo(0);
        assertThat(car.moveIfPossible()).isEqualTo(0);
    }

}