package racing.vehicle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    public void getCarPositions(int number) {
        Cars cars = new Cars(number);
        assertThat(cars.getCarPositions()).isEqualTo(Collections.nCopies(number, 1 ));
    }
}
