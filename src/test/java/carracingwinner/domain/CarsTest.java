package carracingwinner.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,kim,lee:3", "pobi:1"}, delimiter = ':')
    void createTest(String names, int count) {
        Cars cars = new Cars(names.split(","));

        assertThat(cars.getCars().size()).isEqualTo(count);
    }

    @Test
    void moveTest() {
        String names = "pobi,kim,lee";
        Cars cars = new Cars(names.split(","));

        Result result = cars.move();

        assertThat(result.getResult()).isNotEmpty();
        assertThat(result.getWinners().size()).isGreaterThan(0);
    }

}