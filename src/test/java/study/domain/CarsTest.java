package study.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.calculator.Common.toInt;

class CarsTest {
    @ParameterizedTest
    @CsvSource({"1,1","1,2","1,3"})
    void 차주행거리0으로여러개생성(String input, String expected) {
        Cars cars = new Cars(toInt(input),toInt(expected));

        assertThat(cars.getCars()).extracting(car -> car.getDistance().getMove()).containsExactly(toInt(expected));
    }
}