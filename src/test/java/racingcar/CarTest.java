package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @DisplayName("랜덤값 0 ~ 9을 받아서 4이상의 값일 때 true, 아닐때 false")
    @ValueSource(ints = {1, 4, 5, 9})
    void isMoveForward_checkMoveForward(int number) {
        if (number >= 4) {
            assertThat(car.isMoveForward(number)).isTrue();
            return;
        }
        assertThat(car.isMoveForward(number)).isFalse();
    }

    @Test
    @DisplayName("자동차가 주행한 거리 출력")
    void distanceDriven_printDistanceDriven() {
        car.move();
        assertThat(car.distanceDriven()).isNotEmpty();
    }
}
