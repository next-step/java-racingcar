package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,-", "2,1,-", "3,1,-", "1,2,--","2,2,--"})
    void three_cars(int numberOfCar, int count, String expected) {
        Cars cars = new Cars(numberOfCar);
        assertThat(cars.forward(numberOfCar, count)).isEqualTo(expected);
    }

}
