package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 100})
    void constructCarsTest(int size) {
        Cars cars = new Cars(size);
        assertThat(cars.getCarsPosition()).hasSize(size);
    }
}