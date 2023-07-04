package racing.manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

class RacingManagerTest {

    @Test
    @DisplayName("우승자를 선별하는 경우")
    void checkWinnerTest() {
        List<Car> cars = createTestCars();
        RacingManager manager = new RacingManager(cars);
        List<Car> winners = manager.checkWinner();
        assertThat(winners).hasSize(2);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
        assertThat(winners.get(1).getName()).isEqualTo("crong");
    }

    private static List<Car> createTestCars() {
        List<Car> cars = List.of(
          new Car("pobi"),
          new Car("crong"),
          new Car("honux")
        );

        cars.get(0).moveOneStepMoreThanCriterion(5);
        cars.get(0).moveOneStepMoreThanCriterion(5);
        cars.get(0).moveOneStepMoreThanCriterion(5);
        cars.get(1).moveOneStepMoreThanCriterion(5);
        cars.get(1).moveOneStepMoreThanCriterion(5);
        cars.get(1).moveOneStepMoreThanCriterion(5);
        cars.get(2).moveOneStepMoreThanCriterion(5);

        return cars;
    }

}