package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    final static int START_LOCATION = 0;

    @BeforeEach
    public void setUp() {
        car = new Car(START_LOCATION);
    }

    @Test
    @DisplayName("자동차가 움직이면 위치가 변하는지 확인")
    public void move_test() {
        car.move();
        assertThat(car.getLocation()).isEqualTo(START_LOCATION +1);
    }
}
