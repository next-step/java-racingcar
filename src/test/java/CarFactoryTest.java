import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @CsvSource(value = {"'car1,car1,car3':true", "'car1,car2':false"}, delimiter = ':')
    void isDuplicated(String input, boolean expected) {
        List<String> names = Arrays.asList(input.split(","));
        assertThat(CarFactory.isDuplicated(names))
                .isEqualTo(expected);
    }
}