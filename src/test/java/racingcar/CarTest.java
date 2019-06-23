package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;
    Cars cars;

    @BeforeEach
    void setup() {
        car = new Car();

    }

    @Test
    public void moveSuccessTest() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void moveFailTest() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }


}
