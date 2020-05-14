package racingcar;

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

    @DisplayName("자동차는 전진한다")
    @Test
    void move() {
        int position = car.move();
        assertThat(position).isEqualTo(1);
    }

    @DisplayName("자동차는 멈춰있는다")
    @Test
    void stay() {
        int position = car.stay();
        assertThat(position).isEqualTo(0);
    }
}
