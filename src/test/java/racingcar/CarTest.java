package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @Before
    public void setUp() {
        String carId = "aaa";
        car = new Car(carId);
    }

    @Test
    public void 이동하기_이동하는_상황() {
        car.move(9);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동하기_이동하지_않는_상황() {
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 결과를_저장하기위해_Car_객체를_복사() {
        Car newCar = car.copy();

        assertThat(car.getPosition()).isEqualTo(newCar.getPosition());
    }
}