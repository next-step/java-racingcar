package step2.race.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.car.domain.Car;
import step2.car.domain.engine.Engine;
import step2.car.domain.engine.FixedEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    private static List<Car> getCarsHelper(int amount, Engine engine) {
        String name = "carName";
        return IntStream.range(0, amount)
                .mapToObj(index -> String.format("%s%d", name, index))
                .map(carName -> new Car(carName, engine))
                .collect(toList());
    }

    private static List<Car> combineCarsHelper(List<Car> moveCars, List<Car> stopCars) {
        List<Car> carList = new ArrayList<>();
        carList.addAll(moveCars);
        carList.addAll(stopCars);
        return carList;
    }

    private static Stream<Arguments> getCars() {
        Engine moveEngine = new FixedEngine(10);
        Engine stopEngine = new FixedEngine(0);

        List<Car> moveCarList1 = getCarsHelper(1, moveEngine);

        List<Car> moveCarList2 = getCarsHelper(2, moveEngine);
        List<Car> stopCarList1 = getCarsHelper(1, stopEngine);

        return Stream.of(
                Arguments.of(combineCarsHelper(moveCarList1, stopCarList1), new RaceResult(moveCarList1)),
                Arguments.of(combineCarsHelper(moveCarList2, stopCarList1), new RaceResult(moveCarList2))
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