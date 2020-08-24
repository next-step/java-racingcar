package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @Test
    void createCarsTest() {
        assertThat(CarFactory.createCars("pobi,crong,honux")).hasSize(3);
        assertThat(CarFactory.createCars("pobi,crong,honux"))
                .containsExactly( new Car("pobi")
                                , new Car("crong")
                                , new Car("honux"));
    }
}
