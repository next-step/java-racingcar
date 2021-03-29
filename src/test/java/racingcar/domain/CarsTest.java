package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarsTest {

    static Stream<Arguments> carList() {
        return Stream.of(
                arguments(Lists.list(new Car(new Name("pobi")), new Car(new Name("crong")), new Car(new Name("honux"))))
        );
    }

    @ParameterizedTest
    @DisplayName("생성자 테스트")
    @MethodSource("carList")
    void createCars(List<Car> carList) {

        Cars cars = Cars.of(carList);

        assertNotNull(cars);
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

        Cars actual = Cars.of(carList);
        actual.runRound(() -> true);

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

        Cars actual = Cars.of(carList);
        actual.runRound(() -> false);

        assertEquals(expected.getCarsAtRound(), actual.getCarsAtRound());
    }

    @Test
    @DisplayName("우승자 확인 테스트")
    void findWinners() {

        Cars expected = Cars.of(Arrays.asList(
                new Car("pobi", 3),
                new Car("crong", 2),
                new Car("honux", 3)
        ));

        Winners winners = new Winners(Arrays.asList(
                new Name("pobi"),
                new Name("honux")
        ));

        assertThat(expected.getWinners()).isEqualTo(winners);
    }
}
