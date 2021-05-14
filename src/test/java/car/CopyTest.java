package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CopyTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();

        cars.add(new Car("java", 1));
        cars.add(new Car("php", 2));
        cars.add(new Car("python", 3));
    }

    @Test
    void createCopiedCars() {
        Copy copy = new Copy(cars);

        List<Car> copiedCars = copy.createCopiedCars();

        assertThat(cars).isEqualTo(copiedCars);
    }

}
