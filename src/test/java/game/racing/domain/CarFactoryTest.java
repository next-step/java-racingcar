package game.racing.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    private String[] carNames;

    @Before
    public void setUp() {
        this.carNames = new String[]{"pobi", "crong", "honux"};
    }

    @Test
    public void 기본자동차_만들기() {
        List<Car> cars = CarFactory.createDefaultShapeCars(carNames);

        assertCarList(cars);
        assertShape(cars, Car.DEFAULT_CAR_SHAPE);
    }

    @Test
    public void 커스텀_자동차_만들기() {
        final String shape = "+";
        List<Car> customCars = CarFactory.createCustomShapeCars(carNames, shape);

        assertCarList(customCars);
        assertShape(customCars, shape);
    }

    private void assertCarList(List<Car> cars) {
        assertThat(cars.size()).isEqualTo(carNames.length);
        assertThat(cars).allMatch(Objects::nonNull);
        assertThat(cars.stream().map(Car::getName).toArray()).isEqualTo(carNames);
    }

    private void assertShape(List<Car> cars, String shape) {
        for (Car car : cars) {
            assertThat(car.getShape()).isEqualTo(shape);
        }

    }
}