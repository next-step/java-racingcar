package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static Car car = new Car();

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:3", "4:7", "5:12"}, delimiter = ':')
    void go(int size, int score) {
        car.go(size);
        assertThat(car.score).isEqualTo(score);
    }
}