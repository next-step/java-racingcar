package study.racing.model.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import study.racing.model.rule.Rule;

class RacingCarsTest {

    @DisplayName("생성자에 정수가 주어졌을 때 해당 숫자만큼 car가 생성되는지 검증")
    @ParameterizedTest
    @CsvSource({ "1, 1", "100, 100" })
    void createRacingCarsTest(int carCount, int expected) {
        List<Car> cars = createCars(carCount);
        RacingCars racingCars = new RacingCars(cars);

        assertThat(racingCars.getCars().size()).isEqualTo(expected);
    }

    private List<Car> createCars(int carCount) {
        return IntStream.range(0, carCount)
                        .mapToObj(Integer::toString)
                        .map(Car::new)
                        .collect(Collectors.toList());
    }

    @DisplayName("몇 차례 이동한 차들이 주어졌을 때, 현 시점에서 가장 많이 움직인 차를 리턴하는지 검증")
    @ParameterizedTest
    @MethodSource("racingCars")
    void testMostMovedCars(RacingCars racingCars, List<Car> mostMovedCars) {
        assertThat(mostMovedCars).isEqualTo(racingCars.mostMovedCars());
    }

    private static Stream<Arguments> racingCars() {
        Rule trueRule = () -> true;

        Car movedCar1 = new Car("test1");
        movedCar1.moveOrStop(trueRule);
        Car stoppedCar = new Car("test2");

        List<Car> carsWithOnlyWinner = Arrays.asList(movedCar1, stoppedCar);

        Car movedCar2 = new Car("test3");
        movedCar2.moveOrStop(trueRule);
        List<Car> carsWithNultiWinner = Arrays.asList(movedCar1, movedCar2);

        return Stream.of(Arguments.of(new RacingCars(carsWithOnlyWinner), Arrays.asList(movedCar1)),
                         Arguments.of(new RacingCars(carsWithNultiWinner), Arrays.asList(movedCar1, movedCar2)));
    }
}
