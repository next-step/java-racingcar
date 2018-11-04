package racingGame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 차가_앞으로_움직인다() {
        Car car = new Car();

        car.moveForward(5);

        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    public void 차가_앞으로_움직이지_못한다() {
        Car car = new Car();

        car.moveForward(3);

        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }
}