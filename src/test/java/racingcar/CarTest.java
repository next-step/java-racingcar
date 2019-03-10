package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    public void 값_4미만_이동안하기() {
        Car car = new Car();
        car.moveCar(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 값_4이상_이동하기() {
        Car car = new Car();
        car.moveCar(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}