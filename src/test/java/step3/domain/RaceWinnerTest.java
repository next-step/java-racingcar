package step3.domain;

import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.RaceWinner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


class RaceWinnerTest {

    @Test
    public void raceWinnerTest() {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("abc", 1));
        carList.add(new Car("def", 2));
        carList.add(new Car("hig", 3));
        carList.add(new Car("lmn", 3));

        Cars cars = new Cars(carList);

        assertThat(new RaceWinner().getWinners(cars)).containsExactly("hig", "lmn");


    }
}