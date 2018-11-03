package racingGame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 차가_앞으로_움직인다() {
        Car car = new Car();

        car.moveForward();

        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }
}