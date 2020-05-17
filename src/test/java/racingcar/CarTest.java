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

    @DisplayName("막 생성된 자동차의 위치는 0이다")
    @Test
    void newCar_Then_positionIs0() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 전진한다")
    @Test
    void move() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
