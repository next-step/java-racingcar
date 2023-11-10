package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


class RaceWinnerTest {

    @Test
    public void raceWinnerTest() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("abc", 1));
        cars.add(new Car("def", 2));
        cars.add(new Car("hig", 3));
        cars.add(new Car("lmn", 3));

        assertThat(new RaceWinner().getWinners(cars)).containsExactly("hig", "lmn");


    }
}