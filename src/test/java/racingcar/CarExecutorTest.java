package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarExecutorTest {

    @ParameterizedTest
    @ValueSource(ints = {4})
    void initializeCars(int number) {
        assertThat(CarExecutor.initializeCars(number))
                .hasSize(number);
    }
}