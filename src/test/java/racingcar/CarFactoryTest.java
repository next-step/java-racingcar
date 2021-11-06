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
        List<Car> carList = carFactory.buildCars();
        int lengthOfCarList = carList.size();

        assertThat(lengthOfCarList).isEqualTo(NUMBER_OF_CARS);
        checkNumberOfCars(carList);
    }

    private void checkNumberOfCars(List<Car> carList) {
        IntStream.range(0, carList.size())
                .forEach( i -> {
                        Car car = carList.get(i);
                        assertThat(car).isEqualTo(new Car(i+1));
                });
    }
}
