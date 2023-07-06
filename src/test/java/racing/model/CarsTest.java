package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racing.utils.RandomFactory;

class CarsTest {

    @ParameterizedTest
    @MethodSource("createTestCars")
    @DisplayName("경기에 참여 중인 모든 자동차를 이동시키는 경우")
    void moveAllCarsTest(final List<Car> testCars) {
        // given
        final Cars cars = new Cars(testCars);
        final Random moveRandom = RandomFactory.createMoveRandom(Integer.MAX_VALUE);

        // when
        cars.moveCars(moveRandom);

        // then
        assertThat(cars.getCars()).extracting(Car::getPosition)
                                  .doesNotContain(1);
    }

    @ParameterizedTest
    @MethodSource("createMovedTestCars")
    @DisplayName("자동차 중에서 우승자의 이름을 찾기")
    void findWinnerNamesTest(final List<Car> testCars) {
        // given
        final Cars cars = new Cars(testCars);

        // when
        final List<String> winnerNames = cars.findWinnerNames();

        // then
        assertThat(winnerNames).containsExactlyInAnyOrder("pobi", "crong");
    }

    private static Stream<List<Car>> createTestCars() {
        final List<Car> cars = Stream.of("a", "b", "c")
                                     .map(Car::new)
                                     .collect(Collectors.toList());
        return Stream.of(cars);
    }

    private static Stream<List<Car>> createMovedTestCars() {
        final List<Car> cars = Stream.of("pobi", "crong", "honux")
                                     .map(Car::new)
                                     .collect(Collectors.toList());

        moveNSteps(cars.get(0), 3);
        moveNSteps(cars.get(1), 3);
        moveNSteps(cars.get(2), 1);

        return Stream.of(cars);
    }

    private static void moveNSteps(final Car car, final int stepCount) {
        for (int step = 0; step < stepCount; step++) {
            car.move(RandomFactory.createMoveRandom(car.getCriterion()));
        }
    }
}