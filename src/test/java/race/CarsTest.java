package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"0:-", "1:-", "2:-"}, delimiter = ':')
    void three_cars_go(int input, String expected) {
        Cars cars = new Cars(3);
        cars.getCarList().get(input).go();
        assertThat(cars.getCarList().get(input).getMileage()).isEqualTo(expected);
    }

}
