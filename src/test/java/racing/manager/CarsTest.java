package racing.manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.Cars;

class CarsTest {

    @Test
    @DisplayName("우승자를 선별하는 경우")
    void checkWinnerTest() {
        Cars cars = createTestCars();

        List<String> winnerNames = cars.findWinnerNames();

        assertThat(winnerNames).hasSize(2);
        assertThat(winnerNames).containsExactlyInAnyOrder("pobi", "crong");
    }

    private static Cars createTestCars() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        );

        cars.get(0).move(3);
        cars.get(1).move(3);
        cars.get(2).move(1);

        return new Cars(cars);
    }

}