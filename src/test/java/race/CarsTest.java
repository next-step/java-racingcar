package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:---", "1:---", "2:---"}, delimiter = ':')
    void three_cars_three_times_go(int input, String expected) {
        cars.getCars().get(input).go();
        cars.getCars().get(input).go();
        cars.getCars().get(input).go();

        assertThat(cars.getCars().get(input).getMileage()).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"0:-", "1:-", "2:-"}, delimiter = ':')
    void three_cars_go(int input, String expected) {
        cars.getCars().get(input).go();

        assertThat(cars.getCars().get(input).getMileage()).isEqualTo(expected);
    }

}
