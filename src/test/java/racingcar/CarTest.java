package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 이동하기_이동하는_상황() {
        Car car = new Car(0);
        car.move(9);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동하기_이동하지_않는_상황() {
        Car car = new Car(0);
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 위치_출력하기() {
        int id = 0;
        Car car = new Car(id);
        car.move(5);
        car.move(5);

        assertThat(car.displayPosition()).isEqualTo(id + ": --");
    }
}