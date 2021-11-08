package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarFactoryTest {
    private final int NUMBER_OF_CARS = 5;

    @Test
    void testBuildCars() {
        CarFactory carFactory = new CarFactory(NUMBER_OF_CARS);
        List<Car> cars = carFactory.buildCars();
        int lengthOfcars = cars.size();

        assertThat(lengthOfcars).isEqualTo(NUMBER_OF_CARS);
        checkNumberOfCars(cars);
    }

    private void checkNumberOfCars(List<Car> cars) {
        IntStream.range(0, cars.size())
                .forEach( i -> {
                        Car car = cars.get(i);
                        assertThat(car).isEqualTo(new Car(i+1));
                });
    }
}
