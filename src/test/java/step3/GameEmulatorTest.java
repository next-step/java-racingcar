package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;
import step3.domain.RacingGame;
import step3.view.GameEmulator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameEmulatorTest {
    @ParameterizedTest
    @CsvSource(value = {"kyd | 5", "kyd, one | 7", "kyd, one, two | 8"}, delimiter = '|')
    void racingAll(String namesOfCarsText, int numberOfAttempts) {

        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);

        GameEmulator.getResult(racingGame);

        assertThat(racingGame.getRound()).isEqualTo(numberOfAttempts);
    }

    @Test
    void champion() {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("one");
        car1.go(5);
        car1.go(5);
        cars.add(car1);

        Car car2 = new Car("two");
        car2.go(0);
        car2.go(5);
        cars.add(car2);

        assertThat(GameEmulator.getChampions(cars)).containsExactly(car1);
    }

    @Test
    void championWithSamePosition() {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("one");
        car1.go(5);
        car1.go(5);
        cars.add(car1);

        Car car2 = new Car("two");
        car2.go(5);
        car2.go(5);
        cars.add(car2);

        assertThat(GameEmulator.getChampions(cars)).containsExactly(car1, car2);
    }
}