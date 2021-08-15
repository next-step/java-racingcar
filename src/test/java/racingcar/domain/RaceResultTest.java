package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {

    @DisplayName("우승자 찾기")
    @Test
    void findWinners() {
        Car bmw = new Car("bmw");
        Car benz = new Car("benz");
        Car audi = new Car("audi");
        List<Car> cars = Arrays.asList(bmw, benz, audi);
        RaceResult raceResult = new RaceResult(new RoundCount(3), cars);

        moveCars(cars, 3);
        raceResult.report(cars);

        moveCars(cars, 2);
        raceResult.report(cars);

        moveCars(cars, 1);
        raceResult.report(cars);

        List<String> winners = raceResult.findWinners();
        Name name = bmw.getName();
        assertThat(winners).containsExactly(name.getName());
    }

    @DisplayName("복수 우승자 찾기")
    @Test
    void findWinners_MultipleWinners_IfMoveCountAreSame() {
        Car bmw = new Car("bmw");
        Car benz = new Car("benz");
        Car audi = new Car("audi");
        List<Car> cars = Arrays.asList(bmw, benz, audi);
        RaceResult raceResult = new RaceResult(new RoundCount(3), cars);

        moveCars(cars, 3);
        raceResult.report(cars);

        moveCars(cars, 2);
        raceResult.report(cars);

        moveCars(cars, 2);
        raceResult.report(cars);

        List<String> winners = raceResult.findWinners();
        Name bmwName = bmw.getName();
        Name benzName = benz.getName();
        assertThat(winners).containsExactly(bmwName.getName(), benzName.getName());
    }

    private void moveCars(List<Car> cars, int carCount) {
        IntStream.range(0, carCount)
                .forEach((index) -> cars.get(index).move(() -> true));
    }
}
