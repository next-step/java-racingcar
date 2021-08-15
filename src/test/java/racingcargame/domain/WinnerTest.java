package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnerTest {
    @DisplayName("우승자를 찾는다")
    @Test
    void findWinners() {
        List<String> expected = new ArrayList<>();
        expected.add("a");
        List<RacingCar> cars = setRacingCars();

        Winner winner = new Winner(cars);
        List<String> actual = winner.getCarNames();

        assertEquals(expected, actual);
    }

    private List<RacingCar> setRacingCars() {
        List<RacingCar> cars = new ArrayList<>();

        RacingCar car = new RacingCar(new RacingCarName("a"));
        car.tryToMove(5);
        cars.add(car);

        car = new RacingCar(new RacingCarName("b"));
        car.tryToMove(1);
        cars.add(car);
        return cars;
    }
}