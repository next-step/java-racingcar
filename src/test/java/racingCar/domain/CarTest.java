package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
         car = new Car();
    }

    @Test
    @DisplayName("자동차 전진 test")
    void goCar() {
        car.racing(4, new RandomMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 멈춤 test")
    void stopCar() {
        car.racing(2, new RandomMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 3회 이동 test")
    void moveCar() {
        car.racing(4, new RandomMoveStrategy());
        car.racing(2, new RandomMoveStrategy());
        car.racing(7, new RandomMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 위치 toString")
    void drawPosition() {
        car.racing(4, new RandomMoveStrategy());
        car.racing(2, new RandomMoveStrategy());
        car.racing(7, new RandomMoveStrategy());
        assertThat(car.toString()).isEqualTo("--");
    }
}
