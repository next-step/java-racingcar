package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"0:-","1:-","2:-"}, delimiter = ':')
    void cars(int input, String expected) {
        Cars cars = new Cars(new ArrayList<>(), 3);
        assertThat(cars.getCarList().get(input).go(1)).isEqualTo(expected);
    }

}
