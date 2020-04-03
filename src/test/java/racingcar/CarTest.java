package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("항상 성공하는 전략 주입에 따른 포지션 +1")
    @Test
    void moveAlways() {
        Car car = new Car(() -> true);
        assertThat(car.moveIfPossible()).isEqualTo(1);
        assertThat(car.moveIfPossible()).isEqualTo(2);
        assertThat(car.moveIfPossible()).isEqualTo(3);
    }

    @DisplayName("항상 실패하는 전략 주입에 따른 포지션 유지")
    @Test
    void notMove() {
        Car car = new Car(() -> false);
        assertThat(car.moveIfPossible()).isEqualTo(0);
        assertThat(car.moveIfPossible()).isEqualTo(0);
        assertThat(car.moveIfPossible()).isEqualTo(0);
    }
}