package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void diceResults가_모두_1인경우() {
        List<Car> carList = List.of(new Car("a"), new Car("b"), new Car("c"), new Car("d"));
        Cars cars = new Cars(carList);
        List<Integer> diceResults = List.of(1, 1, 1, 1);
        cars.play(diceResults);
        for (Car car : cars.getCars()) {
            assertThat(car.currentPosition()).isEqualTo(0);
        }
    }

    @Test
    void diceResults가_모두_4이상인경우() {
        List<Car> carList = List.of(new Car("a"), new Car("b"), new Car("c"), new Car("d"));
        Cars cars = new Cars(carList);
        List<Integer> diceResults = List.of(4, 4, 4, 4);
        cars.play(diceResults);
        for (Car car : cars.getCars()) {
            assertThat(car.currentPosition()).isEqualTo(1);
        }
    }
}
