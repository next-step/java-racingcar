package racingcar;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.MovingStrategy.RandomMovingStrategy;
import racingcar.domain.Cars;
import racingcar.exception.CreateCarCountException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @DisplayName("Cars 생성 테스트")
    @MethodSource
    void createCarsTest(String[] carNames, Cars expected) {
        Cars cars = Cars.from(carNames, RandomMovingStrategy.getInstance());

        assertThat(cars).isEqualTo(expected);
    }

    static Stream<Arguments> createCarsTest() {
        return Stream.of(
                Arguments.of(
                        new String[] {"aa", "bb", "cc"}, Cars.from(new String[] {"aa", "bb", "cc"}, RandomMovingStrategy.getInstance())
                )
        );
    }

    @Disabled
    @ParameterizedTest
    @DisplayName("Cars 생성 예외 테스트")
    @ValueSource(ints = {-1, 0})
    void carsExceptionTest(int createCount) {
        assertThatThrownBy(() -> Cars.from(new String[] {"aa", "bb"}, RandomMovingStrategy.getInstance())).isInstanceOf(CreateCarCountException.class);
    }

}