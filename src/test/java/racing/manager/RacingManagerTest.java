package racing.manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.Cars;

class RacingManagerTest {

    @Test
    @DisplayName("우승자를 선별하는 경우")
    void checkWinnerTest() {
        Cars cars = createTestCars();
        RacingManager manager = new RacingManager(cars);
        List<String> winnerNames = manager.getWinnerNames();
        assertThat(winnerNames).hasSize(2);
        assertThat(winnerNames.get(0)).isEqualTo("pobi");
        assertThat(winnerNames.get(1)).isEqualTo("crong");
    }

    private static Cars createTestCars() {
        List<Car> cars = List.of(
          new Car("pobi"),
          new Car("crong"),
          new Car("honux")
        );

        moveNSteps(cars.get(0), 3);
        moveNSteps(cars.get(1), 3);
        moveNSteps(cars.get(2), 1);

        return new Cars(cars);
    }

    private static void moveNSteps(Car car, int steps) {
        for (int i = 0; i < steps; i++) {
            car.moveOneStepMoreThanCriterion(5);
        }
    }

}