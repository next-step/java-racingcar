package step05.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static Stream<Arguments> provideCarNamesResult() {
        return Stream.of(
                Arguments.of(
                        new String[]{"eun", "young"},
                        Arrays.asList(
                                Car.of("eun"),
                                Car.of("young")
                        )
                )
        );
    }

    @DisplayName("자동차 이름들을 받아 자동차들 생성")
    @ParameterizedTest
    @MethodSource("provideCarNamesResult")
    public void test_constructor_Cars(String[] carNames, List<Car> expect) {
        Cars cars = Cars.of(carNames);
        assertThat(cars).isEqualTo(Cars.of(expect));
    }

    private static Stream<Arguments> provideMoveResult() {
        return Stream.of(
                Arguments.of(
                        Cars.of(
                                Arrays.asList(
                                        Car.of("eun", 1),
                                        Car.of("young", 2)
                                )
                        ),
                        Cars.of(
                                Arrays.asList(
                                        Car.of("eun", 2),
                                        Car.of("young", 3)
                                )
                        )
                )
        );
    }

    @DisplayName("자동차를 한회차 이동시킴")
    @ParameterizedTest
    @MethodSource("provideMoveResult")
    public void test_move(Cars cars, Cars expect) {
        assertThat(cars.move(() -> true)).isEqualTo(expect);
    }

    private static Stream<Arguments> provideTopPositionCarsResult() {
        return Stream.of(
                Arguments.of(
                        Cars.of(
                                Arrays.asList(
                                        Car.of("eun", 1),
                                        Car.of("young", 2)
                                )
                        ),
                        Cars.of(
                                Arrays.asList(
                                        Car.of("young", 2)
                                )
                        )
                ),
                Arguments.of(
                        Cars.of(
                                Arrays.asList(
                                        Car.of("eun", 6),
                                        Car.of("young", 6)
                                )
                        ),
                        Cars.of(
                                Arrays.asList(
                                        Car.of("eun", 6),
                                        Car.of("young", 6)
                                )
                        )
                )
        );
    }

    @DisplayName("Cars 의 topPositionCar 구하기")
    @ParameterizedTest
    @MethodSource("provideTopPositionCarsResult")
    public void test_findTopPositionCars(Cars cars, Cars expect) {
        assertThat(cars.findTopPositionCars()).isEqualTo(expect);
    }

}
