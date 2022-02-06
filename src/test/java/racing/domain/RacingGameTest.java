package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.car.Car;
import racing.domain.car.Cars;

class RacingGameTest {

    @ParameterizedTest
    @MethodSource
    void 레이싱_무조건_전진_진행(int tryNumberValue, int movableNumber, List<Car> cars) {
        RacingGame racingGame = new RacingGame(() -> movableNumber, cars);
        final List<Cars> racingResult = racingGame.race(new TryNumber((tryNumberValue)));
        int move = 1;
        for (Cars oneRacingCars : racingResult) {
            for (int i = 0; i < oneRacingCars.getCars().size(); i++) {
                assertThat(cars.get(i).getNameValue()).isEqualTo(
                    oneRacingCars.getCars().get(i).getNameValue());
                assertThat(cars.get(i).getPositionValue() + move).isEqualTo(
                    oneRacingCars.getCars().get(i).getPositionValue());
            }
            move++;
        }
    }

    private static Stream<Arguments> 레이싱_무조건_전진_진행() {
        return Stream.of(
            Arguments.of(1, 4, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(2, 5, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(3, 6, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(4, 7, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))));
    }

    @ParameterizedTest
    @MethodSource
    void 레이싱_무조건_스탑_진행(int tryNumberValue, int notMovableNumber, List<Car> cars) {
        RacingGame racingGame = new RacingGame(() -> notMovableNumber, cars);
        final List<Cars> racingResult = racingGame.race(new TryNumber((tryNumberValue)));
        for (Cars oneRacingCars : racingResult) {
            for (int i = 0; i < oneRacingCars.getCars().size(); i++) {
                assertThat(cars.get(i).getNameValue()).isEqualTo(
                    oneRacingCars.getCars().get(i).getNameValue());
                assertThat(cars.get(i).getPositionValue()).isEqualTo(
                    oneRacingCars.getCars().get(i).getPositionValue());
            }
        }
    }

    private static Stream<Arguments> 레이싱_무조건_스탑_진행() {
        return Stream.of(
            Arguments.of(1, 0, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(2, 1, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(3, 2, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(4, 3, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))));
    }

    @ParameterizedTest
    @MethodSource
    void 우승자_결졍(int movableNumber, List<Car> cars) {
        RacingGame racingGame = new RacingGame(() -> movableNumber, cars);
        final List<Car> winners = racingGame.decideWinners();
        assertThat("b").isEqualTo(winners.get(0).getNameValue());
        assertThat(4).isEqualTo(winners.get(0).getPositionValue());
        assertThat("cd").isEqualTo(winners.get(1).getNameValue());
        assertThat(4).isEqualTo(winners.get(1).getPositionValue());
    }

    private static Stream<Arguments> 우승자_결졍() {
        return Stream.of(
            Arguments.of(4, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("cd", 4))));
    }
}