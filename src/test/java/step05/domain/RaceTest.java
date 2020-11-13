package step05.domain;

import exception.NotPositiveIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RaceTest {

    private static Stream<Arguments> provideNotPositiveIntegerResult() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-10),
                Arguments.of(0)
        );
    }

    @DisplayName("경주 횟수가 양수가 아닐때 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideNotPositiveIntegerResult")
    public void test_validateNumberOfMoves(int NotPositiveInteger) {
        Cars cars = Cars.of(
                Arrays.asList(
                        Car.of("eun", 3),
                        Car.of("young", 2)
                )
        );
        assertThatExceptionOfType(NotPositiveIntegerException.class)
                .isThrownBy(() -> Race.of(NotPositiveInteger, cars));
    }

    private static Stream<Arguments> provideRunResult() {
        return Stream.of(
                Arguments.of(
                        3,
                        Cars.of(
                                Arrays.asList(
                                        Car.of("eun", 3),
                                        Car.of("young", 2)
                                )

                        ),
                        true,
                        Arrays.asList(
                                Cars.of(
                                        Arrays.asList(
                                                Car.of("eun", 4),
                                                Car.of("young", 3)
                                        )
                                ),
                                Cars.of(
                                        Arrays.asList(
                                                Car.of("eun", 5),
                                                Car.of("young", 4)
                                        )
                                ),
                                Cars.of(
                                        Arrays.asList(
                                                Car.of("eun", 6),
                                                Car.of("young", 5)
                                        )
                                )
                        )
                )
        );
    }

    @DisplayName("경주 운행 결과")
    @ParameterizedTest
    @MethodSource("provideRunResult")
    public void test_run(int numberOfMoves, Cars cars, boolean movable, List<Cars> expect) {
        Race race = Race.of(numberOfMoves, cars);
        assertThat(race.run(() -> movable)).isEqualTo(expect);
    }

}
