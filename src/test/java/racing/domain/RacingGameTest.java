package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.BasicCar;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.car.FakeBasicCar;
import racing.domain.fuel.Fuel;
import racing.domain.fuel.RandomFuel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    private Cars newCars(String carNames, Function<Name, Car> carCtor) {
        return new Cars(Arrays.stream(carNames.split("\\|"))
                .map(Name::new)
                .map(carCtor)
                .collect(Collectors.toSet()));
    }
    @CsvSource(value = {
            "A|B|C|D",
            "A|B|C|",
            "A"
    })
    @DisplayName("ctor Test")
    @ParameterizedTest
    public void ctorTest(String carNames) {
        Cars cars = newCars(carNames, BasicCar::new);
        new RacingGame(cars);
    }

    @DisplayName("ctor IllegalArgumentException Test")
    @Test
    public void ctorTest_IllegalArgumentException() {
        // Car가 없는 경우
        assertThatThrownBy(() ->
                new RacingGame(null)
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                new RacingGame(new Cars(new HashSet<>()))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(
            "A|B|C|D,E|F,10"
    )
    @ParameterizedTest
    public void racingTest(String carNames, String winnerCarNames, int turnSize) {
        Cars cars = newCars(carNames, BasicCar::new);
        Cars fakeCars = newCars(winnerCarNames, FakeBasicCar::new);
        for (Car iCar : fakeCars)
            cars.add(iCar);
        Fuel fuel = new RandomFuel();

        RacingGame game = new RacingGame(cars);

        Turn turn = game.racing(fuel);
        assertThat(turn.findWinnerNames())
                .containsOnly(winnerCarNames.split("\\|"));
    }
}