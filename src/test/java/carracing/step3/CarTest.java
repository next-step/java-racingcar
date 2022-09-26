package carracing.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 움직임 테스트 : 결과 1")
    void move() {
        car.move(9);
        assertThat(car.moveTrace()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 움직인 자국 테스트 : 결과 1")
    void moveTrace() {
        car.move(9);
        assertThat(car.moveTrace()).isEqualTo(1);
    }
}