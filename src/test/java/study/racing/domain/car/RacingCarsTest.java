package study.racing.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import study.racing.domain.Name;
import study.racing.domain.rule.Rule;

class RacingCarsTest {

    @DisplayName("생성자에 정수가 주어졌을 때 해당 숫자만큼 car가 생성되는지 검증")
    @ParameterizedTest
    @MethodSource("cars")
    void createRacingCarsTest(List<Car> cars, int expected) {
        RacingCars racingCars = new RacingCars(cars);
        assertThat(racingCars.getCars().size()).isEqualTo(expected);
    }

    private static Stream<Arguments> cars() {
        int firstCarCount = 1;
        List<Car> firstCars = makeCars(firstCarCount);

        int secondCarCount = 100;
        List<Car> secondCars = makeCars(secondCarCount);

        return Stream.of(Arguments.of(firstCars, firstCarCount), Arguments.of(secondCars, secondCarCount));
    }

    private static List<Car> makeCars(int carCount) {
        return IntStream.range(0, carCount)
                        .mapToObj(Integer::toString)
                        .map(Name::new)
                        .map(Car::new)
                        .collect(Collectors.toList());
    }

    @DisplayName("몇 차례 이동한 차들이 주어졌을 때, 현 시점에서 가장 많이 움직인 차를 리턴하는지 검증")
    @ParameterizedTest
    @ArgumentsSource(RacingCarsProvider.class)
    void mostMovedCarsTest(RacingCars racingCars, List<Car> mostMovedCars) {
        assertThat(mostMovedCars).isEqualTo(racingCars.mostMovedCars());
    }

    static class RacingCarsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            Rule trueRule = () -> true;

            Car firstMovedCar = new Car(new Name("test1"));
            Car secondMovedCar = new Car(new Name("test2"));
            Car stoppedCar = new Car(new Name("test3"));

            firstMovedCar.moveOrStop(trueRule);
            secondMovedCar.moveOrStop(trueRule);

            List<Car> carsWithOnlyWinner = Arrays.asList(firstMovedCar, stoppedCar);
            List<Car> carsWithMultiWinner = Arrays.asList(firstMovedCar, secondMovedCar);
            return Stream.of(Arguments.of(new RacingCars(carsWithOnlyWinner), Arrays.asList(firstMovedCar)),
                             Arguments.of(new RacingCars(carsWithMultiWinner), carsWithMultiWinner));
        }
    }
}
