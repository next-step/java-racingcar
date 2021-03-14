package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;
import step3.domain.Cars;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        this.cars = new Cars();
    }

    @DisplayName("제일 많이 가면 우승자")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4", "5"})
    void winners(int maxPosition) {
        givenCar(cars, maxPosition);

        List<Car> winners = cars.getWinners();

        assertEquals(maxPosition, winners.get(0).getPosition());
    }

    private void givenCar(Cars cars, int max) {
        cars.addCar(new Car("max-2", max - 2));
        cars.addCar(new Car("max-1", max - 1));
        cars.addCar(new Car("max1", max));
        cars.addCar(new Car("max2", max));
    }
}
