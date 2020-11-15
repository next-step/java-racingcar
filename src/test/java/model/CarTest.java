package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp () {
        car = new Car("Test");
    }

    @Test
    @DisplayName("자동차 전진")
    void stepForward () {
        car.stepForward(() -> true);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("자동차 정지")
    void stepStop () {
        car.stepForward(() -> false);
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

}