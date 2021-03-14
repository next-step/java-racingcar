import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.CarFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"'car1,car2,car3':3", "'car1,car2':2"}, delimiter = ':')
    void generateCars(String input, int result) {
        List<String> names = Arrays.asList(input.split(","));
        assertThat(CarFactory.generateCars(names)
                .getCars()
                .size())
                .isEqualTo(result);
    }
}