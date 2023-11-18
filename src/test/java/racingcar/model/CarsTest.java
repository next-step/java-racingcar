package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

        @Test
        void 우승자_찾기() {
                Car car1 = new Car("car1", () -> true);
                Car car2 = new Car("car2", () -> true);
                Car car3 = new Car("car3", () -> false);
                Car car4 = new Car("car4", () -> false);
                List<Car> winners = List.of(car1, car2);
                Cars cars = new Cars(List.of(car1, car2, car3, car4));
                assertThat(cars.findWinners().containsAll(winners)).isTrue();
        }
}
