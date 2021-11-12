package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.RacingCarTestUtil.*;

public class CarFactoryTest {

    private final String[] NAME_OF_CARS_INCLUDING_LONG_NAME = new String[]{"pobi", "tomotomo", "crong", "honux", "yong"};

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

    @Test
    void testBuildCarsWithLongName() {
        CarFactory carFactory = new CarFactory(NAME_OF_CARS_INCLUDING_LONG_NAME);
        assertThatThrownBy(carFactory::buildCars).isInstanceOf(IllegalArgumentException.class);
    }
}
