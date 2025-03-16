package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {4})
    void initializeCars(int number) {
        assertThat(Cars.initializeCars(number))
                .hasSize(number);
    }
}