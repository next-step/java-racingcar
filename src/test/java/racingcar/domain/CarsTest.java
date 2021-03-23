package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.exception.Message.EMPTY_CARS_ERROR;

class CarsTest {

    static Stream<Arguments> carList() {
        return Stream.of(
                arguments(Lists.list(new Car("pobi"), new Car("crong"), new Car("honux")))
        );
    }

    @ParameterizedTest
    @DisplayName("생성자 테스트")
    @MethodSource("carList")
    void createCars(List<Car> carList) {
        Cars cars = Cars.of(carList);
        assertNotNull(cars);
    }

    @Test
    @DisplayName("생성자 예외 테스트")
    void createEmptyCars() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.of(new String[]{}))
                .withMessage(EMPTY_CARS_ERROR);
    }

    @ParameterizedTest
    @DisplayName("한 라운드 전체 전진 테스트")
    @MethodSource("carList")
    void runRoundMove(List<Car> carList) {
        Cars expected = Cars.of(Arrays.asList(
                new Car("pobi", 1),
                new Car("crong", 1),
                new Car("honux", 1)
        ));
        Cars actual = Cars.of(carList).runRound(() -> true);
        assertEquals(expected.getCarsAtRound(), actual.getCarsAtRound());
    }

    @ParameterizedTest
    @DisplayName("한 라운드 전체 멈춤 테스트")
    @MethodSource("carList")
    void runRoundStop(List<Car> carList) {
        Cars expected = Cars.of(Arrays.asList(
                new Car("pobi", 0),
                new Car("crong", 0),
                new Car("honux", 0)
        ));
        Cars actual = Cars.of(carList).runRound(() -> false);
        assertEquals(expected.getCarsAtRound(), actual.getCarsAtRound());
    }
}
