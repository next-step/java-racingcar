package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FilterWinnersTest {
    @ParameterizedTest
    @MethodSource("movementsAndExpectedWinnerIndexForThreeCars")
    void filter(List<Integer> movements, List<Integer> winnnerIndexes) {
        List<Car> cars = Arrays.asList(
                new Car(new CarName("car1")),
                new Car(new CarName("car1")),
                new Car(new CarName("car1"))
        );

        for (int i = 0; i < movements.size(); i++) {
            move(cars.get(i), movements.get(i));
        }

        assertThat(new FilterWinners().filter(cars))
                .containsExactly(expectedWinners(winnnerIndexes, cars));
    }

    private Car[] expectedWinners(List<Integer> winnnerIndexes, List<Car> cars) {
        return (Car[]) winnnerIndexes.stream().map((index) -> cars.get(index)).toArray();
    }

    private void move(Car car, int numberOfMovement) {
        for (int i = 0; i < numberOfMovement; i++) {
            car.move();
        }
    }

    private static Stream<Arguments> movementsAndExpectedWinnerIndexForThreeCars() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Collections.singletonList(2)),
                Arguments.of(Arrays.asList(3, 2, 1), Collections.singletonList(0)),
                Arguments.of(Arrays.asList(3, 3, 1), Arrays.asList(0, 1)),
                Arguments.of(Arrays.asList(1, 3, 3), Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 1, 1), Arrays.asList(0, 1, 2)),
                Arguments.of(Arrays.asList(0, 0, 0), Arrays.asList(0, 1, 2))
        );
    }
}