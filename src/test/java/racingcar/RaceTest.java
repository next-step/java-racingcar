package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Movement;
import racingcar.domain.Race;
import racingcar.utils.TestMovement;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    void run_cars_움직일때() {
        String[] carNames = {"truck", "cycle", "kiki"};
        Cars cars = new Cars(carNames);
        Movement movement = new TestMovement(4);
        Race race = new Race(cars, movement);
        race.run();
        for (Car car : cars.getCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @Test
    void run_cars_안움직일때() {
        String[] carNames = {"truck", "cycle", "kiki"};
        Cars cars = new Cars(carNames);
        Movement movement = new TestMovement(1);
        Race race = new Race(cars, movement);
        race.run();
        for (Car car : cars.getCars()) {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }
}
