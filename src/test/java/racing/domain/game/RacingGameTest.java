package racing.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.entity.BasicCar;
import racing.domain.car.entity.Car;
import racing.domain.car.entity.Cars;
import racing.domain.car.entity.fake.FakeBasicCar;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.car.vo.fuel.RandomFuel;
import racing.domain.game.dto.Turns;
import racing.exception.InvalidInputException;

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
            "A|B|C|D,10",
            "A|B|C|,15",
            "A,20"
    })
    @DisplayName("ctor Test")
    @ParameterizedTest
    public void ctorTest(String carNames, int turnSize) {
        Cars cars = newCars(carNames, BasicCar::new);
        Turns turns = new Turns(turnSize);
        new RacingGame(cars, turns);
    }

    @DisplayName("ctor IllegalArgumentException Test")
    @Test
    public void ctorTest_IllegalArgumentException() {
        // Car가 없는 경우
        assertThatThrownBy(() ->
                new RacingGame(null, new Turns(1))
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                new RacingGame(new Cars(new HashSet<>()), new Turns(1))
        ).isInstanceOf(IllegalArgumentException.class);

        Cars sampleCars = newCars("A|B|C", BasicCar::new);

        // Turn이 없는 겿우
        assertThatThrownBy(() ->
                new RacingGame(sampleCars, null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(
            "A|B|C|D,E|F,10"
    )
    @ParameterizedTest
    public void racingAllTest(String carNames, String winnerCarNames, int turnSize) {
        Cars cars = newCars(carNames, BasicCar::new);
        Cars fakeCars = newCars(winnerCarNames, FakeBasicCar::new);
        for (Car iCar : fakeCars)
            cars.add(iCar);
        Fuel fuel = new RandomFuel();

        RacingGame game = new RacingGame(cars, new Turns(turnSize));

        Turns turns = game.racingAll(fuel);
        assertThat(turns.lastTurn().findWinnerNames())
                .containsOnly(winnerCarNames.split("\\|"));
    }
}