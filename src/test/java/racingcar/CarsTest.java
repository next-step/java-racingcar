package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;
import racingcar.exception.CreateCarCountException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @DisplayName("Cars 생성 테스트")
    @MethodSource
    void createCarsTest(int createCount, Cars expected) {
        Cars cars = Cars.from(createCount);

        assertThat(cars).isEqualTo(expected);
    }

    static Stream<Arguments> createCarsTest() {
        return Stream.of(
                Arguments.of(
                        1, Cars.from(1)
                ),
                Arguments.of(
                        2, Cars.from(2)
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Cars 생성 예외 테스트")
    @ValueSource(ints = {-1, 0})
    void carsExceptionTest(int createCount) {
        assertThatThrownBy(() -> Cars.from(createCount)).isInstanceOf(CreateCarCountException.class);
    }

}