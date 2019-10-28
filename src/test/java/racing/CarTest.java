package racing;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 이동성공테스트(int tries) {
        car = new Car(() -> true);

        IntStream.range(0, tries)
            .forEach(i -> car.move());

        assertThat(car.getPosition()).isEqualTo(tries);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 이동실패테스트(int tries) {
        car = new Car(() -> false);

        IntStream.range(0, tries)
            .forEach(i -> car.move());

        assertThat(car.getPosition()).isEqualTo(0);

    }
}