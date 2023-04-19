package car;

import domain.car.Car;
import domain.car.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("게임 우승자 결과를 반환할 수 있다")
    @Test
    public void winner() {
        Car car1 = new Car("TEST1", () -> true);
        Car car2 = new Car("TEST2", () -> false);
        Car car3 = new Car("TEST3", () -> false);

        Cars cars = new Cars(List.of(car1, car2, car3));
        cars.move();
        List<Car> winners = cars.findWinners();

        assertThat(winners.get(0)).isEqualTo(car1);
    }

    @DisplayName("게임 우승자 여러명인 경우 결과를 반환할 수 있다")
    @Test
    public void winners() {
        Car car1 = new Car("TEST1", () -> true);
        Car car2 = new Car("TEST2", () -> true);
        Car car3 = new Car("TEST3", () -> false);

        Cars cars = new Cars(List.of(car1, car2, car3));
        cars.move();
        List<Car> winners = cars.findWinners();

        assertThat(winners).containsExactly(car1, car2);
    }
}
