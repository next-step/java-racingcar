package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Cars;
import racing.domain.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars testCars = null;

    @BeforeEach
    void setUp() {
        List<String> names = IntStream.range(0, 3)
                .mapToObj(i -> String.format("car%d", i))
                .collect(Collectors.toList());
        testCars = new Cars(names);
    }

    @DisplayName("자동차들은 이동후 Position 증가한다")
    @Test
    void carMoveForward() {
        testCars.run(new CarHaveToMoveStrategyImpl());
        assertThat(testCars.getCars()).allMatch(car -> car.getPosition().getCurrentPosition() == 1);
    }

    @DisplayName("특정 위치에 해당하는 자동차를 반환한다")
    @Test
    void getCarsEqualsPositionTest() {
        testCars.run(new CarHaveToMoveStrategyImpl());
        assertThat(testCars.getCarsEqualsPosition(new Position(1))).hasSize(3);
    }

    @DisplayName("제일 많이 전진한 자동차의 위치 가져온다")
    @ArgumentsSource(value = MyArgumentsProvider.class)
    @ParameterizedTest
    void getMaxPositionTest(Cars cars) {
        assertThat(cars.getMaxPosition().getCurrentPosition()).isEqualTo(2);
    }

    @DisplayName("제일 많이 전진한 자동차의 대수를 가져온다")
    @MethodSource("provideSource")
    @ParameterizedTest
    void getMaxPositionTest(Cars cars, int expected) {
        assertThat(cars.getCarsEqualsPosition(cars.getMaxPosition())).hasSize(expected);
    }

    private static Stream<Arguments> provideSource() {
        Cars firstCars = new Cars(List.of("CarA", "CarB"));
        firstCars.run(new CarHaveToMoveStrategyImpl());
        firstCars.run(new CarHaveToMoveStrategyImpl());

        Cars secondCars = new Cars(List.of("CarA", "CarB"));
        secondCars.run(new CarHaveToMoveStrategyImpl());

        return Stream.of(Arguments.of(firstCars, 2), Arguments.of(secondCars, 2));
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            Cars cars = new Cars(List.of("CarA", "CarB"));
            cars.run(new CarHaveToMoveStrategyImpl());
            cars.run(new CarHaveToMoveStrategyImpl());
            return Stream.of(cars).map(Arguments::of);
        }
    }
}