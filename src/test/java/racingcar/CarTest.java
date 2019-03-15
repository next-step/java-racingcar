package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 이동하기_이동하는_상황() {
        Car car = new Car("aaa");
        car.move(9);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동하기_이동하지_않는_상황() {
        Car car = new Car("bbb");
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}