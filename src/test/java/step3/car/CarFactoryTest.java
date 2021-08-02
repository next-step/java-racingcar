package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarFactoryTest {

    private CarFactory carFactory = new CarFactory();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10})
    @DisplayName("매개변수만큼 Car를 생성한다")
    void generateCar(int expected) {
        List<Car> cars = carFactory.generateCar(expected);
        int actual = cars.size();
        assertEquals(actual, expected);
    }
}