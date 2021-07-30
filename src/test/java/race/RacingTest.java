package race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.RacingGame;
import racing.model.Car;
import racing.model.Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    List<Car> cars = new ArrayList<>();
    Racing racing;

    @Test
    @DisplayName("winner test")
    void winnerTest() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("test1", 10));
        testCars.add(new Car("test2", 30));
        testCars.add(new Car("test3", 20));
        cars = testCars;
        racing = new Racing(testCars);
        assertThat(racing.winnerCarList().get(0).carName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("more than one winner test")
    void moreThanOneWinnerTest() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("test1", 30));
        testCars.add(new Car("test2", 30));
        testCars.add(new Car("test3", 30));
        cars = testCars;
        racing = new Racing(cars);
        Assertions.assertThat(racing.winnerCarList().stream())
                .extracting(Car::carName)
                .containsExactly("test1", "test2", "test3");
    }

    @Test
    @DisplayName("during game car moving test")
    void duringGameCarMovingTest() {
        RacingGame racingGame = new RacingGame(1);
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("test1"));
        testCars.add(new Car("test2"));
        testCars.add(new Car("test3"));
        cars = testCars;
        racing = new Racing(cars);
        racingGame.gameStart(racing);
        List<Integer> distanceList = cars.stream()
                .map(car -> car.totalDistance())
                .collect(Collectors.toList());
        for(int distance : distanceList) {
            assertThat(distance == 0 || distance == 1).isEqualTo(true);
        }

    }

}
