package com.next.step.step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.next.step.step3.domain.CarsFixture.동일한_2개_위치_CARS;
import static com.next.step.step3.domain.CarsFixture.동일한_위치_CARS;
import static com.next.step.step3.domain.CarsFixture.유일한_위치_CARS;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest(name = "자동차들이 주어질 때 MaxPosition을 찾는 테스트")
    @MethodSource("provideCars")
    void findMaxPosition_가장_이동많은_차_위치(List<Car> cars, int expected) {
        Cars createdCar = new Cars(cars);
        assertThat(createdCar.findMaxPosition()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "자동차들이 주어질 때 승자들의 이름을 찾는 테스트")
    @MethodSource("provideDefaultMaxPositionCars")
    void findMaxPosition_승자_이름(List<Car> cars, List<String> expected) {
        int defaultMaxPosition = 3;
        Cars createdCar = new Cars(cars);
        assertThat(createdCar.getWinnerNames(defaultMaxPosition)).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> provideCars() {
        return Stream.of(
                Arguments.of(동일한_위치_CARS(), 3),
                Arguments.of(동일한_2개_위치_CARS(), 3),
                Arguments.of(유일한_위치_CARS(), 3)
        );
    }

    static Stream<Arguments> provideDefaultMaxPositionCars() {
        return Stream.of(
                Arguments.of(동일한_위치_CARS(), List.of("a", "b", "c")),
                Arguments.of(동일한_2개_위치_CARS(), List.of("b", "c")),
                Arguments.of(유일한_위치_CARS(), List.of("c"))
        );
    }
}
