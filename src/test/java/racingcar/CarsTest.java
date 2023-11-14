package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Position;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {

    @Test
    void test_가장_앞에_있는_차_반환하기() {
        Car winner = new Car("우승자", new Position(4));
        Car loser = new Car("시민", new Position(1));
        Cars cars = new Cars(List.of(winner, loser));

        assertTrue(cars.getWinners().contains(winner));
    }

    @Test
    void test_우승자가_여러명일_경우() {
        Car winner1 = new Car("우승자", new Position(4));
        Car winner2 = new Car("우승자", new Position(4));
        Car loser = new Car("시민", new Position(1));
        Cars cars = new Cars(List.of(winner1, winner2, loser));

        assertTrue(cars.getWinners().containsAll(List.of(winner1, winner2)));
    }
}
