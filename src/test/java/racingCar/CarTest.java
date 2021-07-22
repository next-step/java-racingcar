package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.model.Car;
import racingCar.utils.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void canGo() {
        int number = RandomUtil.getNumber();
        assertThat(car.canMove(number)).isEqualTo(number >= 4);
    }
}