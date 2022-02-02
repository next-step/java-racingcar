package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    private static Stream<Arguments> Car들_중_최대_위치_값_확인() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    new Car("a", 2),
                    new Car("b", 4),
                    new Car("C", 1)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource
    void Car들_중_최대_위치_값_확인(List<Car> parameterCars) {
        final Cars cars = new Cars(parameterCars);
        assertThat(cars.getMaxPosition()).isEqualTo(4);
    }
}