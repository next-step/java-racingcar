package race.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.domain.Cars;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"0:2:--","1:2:--","2:2:--", "0:1:-", "1:1:-", "2:1:-"}, delimiter = ':')
    void cars_go(int index, int count, String expected) {
        Cars cars = new Cars(new ArrayList<>(), 3);
        assertThat(cars.getCarList().get(index).go(count)).isEqualTo(expected);
    }

}
