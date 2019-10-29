package step2.race.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.car.domain.Car;
import step2.car.domain.engine.Engine;
import step2.car.domain.engine.FixedEngine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    private static Stream<Arguments> getCars() {
        Engine moveEngine = new FixedEngine(10);
        Engine stopEngine = new FixedEngine(0);

        Car moveCar1 = new Car("moveOne", moveEngine);
        Car moveCar2 = new Car("moveTwo", moveEngine);
        Car moveCar3 = new Car("moveThree", moveEngine);

        Car stopCar1 = new Car("stopOne", stopEngine);

        return Stream.of(
                Arguments.of(Arrays.asList(moveCar1, stopCar1), new RaceResult(Arrays.asList(moveCar1))),
                Arguments.of(Arrays.asList(moveCar2, moveCar3, stopCar1), new RaceResult(Arrays.asList(moveCar2, moveCar3)))
        );
    }

    @ParameterizedTest
    @MethodSource("getCars")
    public void getWinnersNames_우승한_자동차_결과가져오기(List<Car> cars, RaceResult raceResult) {
        //given
        Race race = new Race(cars);

        //when
        race.moveAll();

        //then
        assertThat(race.getResult().getWinnersNames()).isEqualTo(raceResult.getWinnersNames());
    }
}