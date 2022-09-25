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
    @DisplayName("자동차 움직임 테스트 : 결과 PASS")
    void move() {
        car.move();
        assertThat(car.moveTrace()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 움직인 자국 테스트 : 결과 -")
    void moveTrace() {
        car.move();
        assertThat(car.moveTrace()).isEqualTo("-");
    }
}