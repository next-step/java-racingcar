package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domains.Car;
import racingCar.domains.Winner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void name() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a", 2));
        cars.add(new Car("b"));
        cars.add(new Car("c", 2));

        assertThat(Winner.findWinner(cars)).containsExactlyInAnyOrder(new Car("c", 2), new Car("a", 2));
    }
}
