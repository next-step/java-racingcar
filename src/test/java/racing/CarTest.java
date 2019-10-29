package racing;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private Car car;

    @ParameterizedTest
    @CsvSource(value = {"1:test1", "2:test2", "3:test3"}, delimiter = ':')
    void 이동성공테스트(int tries, String name) {
        car = new Car(() -> true, name);

        IntStream.range(0, tries)
            .forEach(i -> car.move());

        assertThat(car.getPosition()).isEqualTo(tries);
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:test1", "2:test2", "3:test3"}, delimiter = ':')
    void 이동실패테스트(int tries, String name) {
        car = new Car(() -> false, name);

        IntStream.range(0, tries)
            .forEach(i -> car.move());

        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo(name);
    }
}