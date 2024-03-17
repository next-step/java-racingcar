package RacingGame;

import RacingGame.model.Car;
import RacingGame.model.CarsManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsManagerTest {
    @ParameterizedTest(name = "차량 위치 : {1}")
    @MethodSource("initCar")
    @DisplayName("초기 입력한 차량 위치에 대한 반환 확인")
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

    @Test
    @DisplayName("우승한 차량을 반환 테스트")
    void winnerCarsTest() {
        List<Car> cars = List.of(
                new Car("1등", 5),
                new Car("2등", 4),
                new Car("3등", 3),
                new Car("4등", 2)
        );

        CarsManager carsManager = new CarsManager(cars);

        assertThat(carsManager.winners().name()).isEqualTo("1등");
    }
}
