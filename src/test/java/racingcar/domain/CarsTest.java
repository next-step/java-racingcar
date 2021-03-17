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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarsTest {

    private int carCount = 3;

    static Stream<Arguments> carList() {
        return Stream.of(
                arguments(Lists.list(new Car(), new Car(), new Car()))
        );
    }

    @Test
    @DisplayName("생성자 테스트")
    void createCars() {
        Cars cars;
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        cars = Cars.of(carList);
        assertNotNull(cars);
    }

    @ParameterizedTest
    @DisplayName("한 라운드 전체 전진 테스트")
    @MethodSource("carList")
    void runRoundMove(List<Car> carList) {
        Cars expected = Cars.of(Arrays.asList(
                new Car(1),
                new Car(1),
                new Car(1)
        ));
        Cars actual = Cars.of(carList).runRound(() -> true);
        assertEquals(expected.getCarsAtRound(), actual.getCarsAtRound());
    }

    @ParameterizedTest
    @DisplayName("한 라운드 전체 멈춤 테스트")
    @MethodSource("carList")
    void runRoundStop(List<Car> carList) {
        Cars expected = Cars.of(Arrays.asList(
                new Car(0),
                new Car(0),
                new Car(0)
        ));
        Cars actual = Cars.of(carList).runRound(() -> false);
        assertEquals(expected.getCarsAtRound(), actual.getCarsAtRound());
    }
}
