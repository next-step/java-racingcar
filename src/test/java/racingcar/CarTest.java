package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.domain.Car;
import racingcar.domain.CarDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @Before
    public void setUp() {
        String carName = "aaa";
        car = new Car(carName);
    }

    @Test
    public void 이동하기_이동하는_상황() {
        car.move(4);
        CarDTO carDTO = car.toCarDTO();

        assertThat(carDTO.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동하기_이동하지_않는_상황() {
        car.move(3);
        CarDTO carDTO = car.toCarDTO();

        assertThat(carDTO.getPosition()).isEqualTo(0);
    }
}