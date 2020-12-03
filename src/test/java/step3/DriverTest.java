package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    List<Car> cars;
    Driver driver;

    @BeforeEach
    void setUp() {
        cars = makeCars(3);
        driver = new Driver(cars);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:-", "3:''" }, delimiter = ':')
    @DisplayName("숫자에 따른 운전 기능 테스트 (4이상 숫자면 모두 1칸이동, 4미만 숫자면 모두 0칸이동)")
    void drive(int input, String expected) {
        driver.drive(input);
        cars.stream()
                .map(Car::getDistance)
                .forEach(distance -> assertThat(distance).isEqualTo(expected));
    }

    private List<Car> makeCars(int numOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i=0; i<numOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}