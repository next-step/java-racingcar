package car;

import car.domain.Car;
import car.domain.Cars;
import car.domain.Copy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CopyTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> tempCars = new ArrayList<>();

        tempCars.add(new Car("java", 1));
        tempCars.add(new Car("php", 2));
        tempCars.add(new Car("python", 3));

        cars = new Cars(tempCars);
    }

    @Test
    void createCopiedCars() {
        Copy copy = new Copy(cars);

        Cars copiedCars = copy.createCopiedCars();

        assertThat(cars.getCars()).usingFieldByFieldElementComparator().isEqualTo(copiedCars.getCars());
    }

}
