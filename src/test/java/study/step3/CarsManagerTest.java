package study.step3;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.Model.Car;
import step3.Model.CarsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsManagerTest {
    @ParameterizedTest(name = "차량 위치 : {1}")
    @MethodSource("initCar")
    @DisplayName("초기 차량 위치에 대해 반환한다.")
    void getCarsDistanceTest(List<Car> cars, List<Integer> positions) {
        //given
        CarsManager carsManager = new CarsManager(cars);

        //when
        List<Integer> expected = positions;
        List<Integer> result = carsManager.getCarsPosition();

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static List<Integer> givenPositions(int... positions) {
        return Arrays.stream(positions)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    private static List<Car> givenCars(List<Integer> positions) {
        return positions.stream()
                .map(position -> new Car(position))
                .collect(Collectors.toList());
    }

    static Stream<Arguments> initCar() {
        return Stream.of(
                Arguments.arguments(givenCars(givenPositions(1, 2, 3)), givenPositions(1, 2, 3)),
                Arguments.arguments(givenCars(givenPositions(2, 3, 4)), givenPositions(2, 3, 4)),
                Arguments.arguments(givenCars(givenPositions(3, 4, 5)), givenPositions(3, 4, 5)),
                Arguments.arguments(givenCars(givenPositions(4, 5, 6)), givenPositions(4, 5, 6)),
                Arguments.arguments(givenCars(givenPositions(5, 6, 7)), givenPositions(5, 6, 7))
        );
    }
}
