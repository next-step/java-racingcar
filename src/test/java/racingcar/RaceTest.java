package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void createThreeCars() {
        Race race = new Race(new RandomStrategy());
        String[] carNames = {"pobi", "crong", "honux"};
        assertThat(race.createCars(carNames)).hasSize(3);
    }

    @Test
    void CarShouldMove() {
        Car car = new Car("test");
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void findWinners() {
        Race race = new Race(new RandomStrategy());
        String[] carNames = {"pobi", "crong", "honux"};
        race.createCars(carNames);
        List<Car> cars = race.cars;
        cars.get(0).move();
        List<String> expected = new ArrayList<String>() {{
            add("pobi");
        }};
        assertThat(race.findWinners()).isEqualTo(expected);
        cars.get(2).move();
        expected.add("honux");
        assertThat(race.findWinners()).isEqualTo(expected);
    }

    @Test
    void rollTest() {
        Car car = new Car("test");
        Race race = new Race(new RandomStrategy());
        RolledResult movedResult = race.roll(car);
        if (movedResult.isMoved) {
            assertThat(movedResult.car.getPosition()).isEqualTo(2);
        } else {
            assertThat(movedResult.car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void rollCarsTestWithAlwaysWinStrategy() {
        String[] carNames = {"pobi", "crong", "honux"};
        Race race = new Race(new AlwaysWinStrategy());
        race.createCars(carNames);
        race.rollCars();
        for (Car car : race.cars) {
            assertThat(car.getPosition()).isEqualTo(2);
        }
    }
}
