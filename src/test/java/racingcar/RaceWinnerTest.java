package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.race.Car;
import racingcar.model.race.RaceWinner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceWinnerTest {

    @Test
    public void decideWinner() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("kb", 4));
        cars.add(new Car("sm", 3));
        cars.add(new Car("jh", 4));

        RaceWinner winner = new RaceWinner(cars);

        assertThat(winner.getWinners()).map(Car::getName).containsExactly("kb", "jh");
    }
}
