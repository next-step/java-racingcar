package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    private static Stream<Arguments> 중복된_이름_확인() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    new Car("a", 2),
                    new Car("a", 4),
                    new Car("C", 1)
                )
            )
        );
    }

    private static Stream<Arguments> 자동차_개수_확인() {
        return Stream.of(
            Arguments.of(Arrays.asList())
        );
    }

    @ParameterizedTest
    @MethodSource
    void Car들_중_최대_위치_값_확인(List<Car> parameterCars) {
        final Cars cars = new Cars(parameterCars);
        assertThat(cars.getMaxPosition()).isEqualTo(4);
    }

    @ParameterizedTest
    @MethodSource
    void 중복된_이름_확인(List<Car> parameterCars) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Cars(parameterCars)).withMessage("[ERROR] 중복된 이름은 들어갈 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource
    void 자동차_개수_확인(List<String> parameterCars) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Cars(parameterCars, 0))
            .withMessage("[ERROR] 자동차 개수는 적어도 1개 이상이어야 합니다.");
    }
}