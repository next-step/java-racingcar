package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCarTestUtil.*;

public class CarFactoryTest {

    @Test
    void testBuildCars() {
        CarFactory carFactory = new CarFactory(NAMES_OF_CARS);
        Cars cars = carFactory.buildCars();

        assertThat(cars.sizeEqualTo(NUMBER_OF_CARS)).isTrue();
        checkExistenceOfCars(cars);
    }

    private void checkExistenceOfCars(Cars cars) {
        Arrays.stream(NAMES_OF_CARS)
                .forEach( name -> assertThat(cars.contains(new Car(name))).isTrue());
    }
}
