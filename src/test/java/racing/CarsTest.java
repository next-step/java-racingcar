package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarsTest {

    Cars testCars;

    @BeforeEach
    void setUp() {
        testCars = Cars.createCars(3);
    }

    @ParameterizedTest
    @DisplayName("cars generate test")
    @CsvSource(value = {"1,1","10,10"})
    void createCars(int input, int expected) {
        Cars cars = Cars.createCars(input);
        Assertions.assertThat(cars.valueOf()).hasSize(expected);
    }
}
