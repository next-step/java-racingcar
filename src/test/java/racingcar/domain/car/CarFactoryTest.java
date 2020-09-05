package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.car.CarFactory.createCars;

public class CarFactoryTest {

    @Test
    void createCarsTest() {
        Car[] expectedCars = {new Car("pobi"),new Car("crong"), new Car("honux")};

        assertThat(createCars("pobi,crong,honux"))
                .hasSize(3)
                .containsExactly(expectedCars);
    }
}
