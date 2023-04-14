package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("모든 자동차 리스트를 반환해야 한다")
    public void all() {
        Car car1 = new Car("a", () -> 0);
        Car car2 = new Car("b", () -> 0);

        Cars cars = Cars.of(car1, car2);
        List<Car> allCars = cars.all();

        assertThat(allCars).hasSize(2);
        assertThat(allCars).containsExactly(car1, car2);
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("모든 자동차가 움직여야 한다")
    public void move(int movement) {
        Car car1 = new Car("a", () -> movement);
        Car car2 = new Car("b", () -> movement);
        Car car3 = new Car("c", () -> movement);

        Cars cars = Cars.of(car1, car2, car3);
        Distance distance = new Distance(movement);

        cars.move();

        cars.all().forEach((car) -> assertThat(car.distance()).isEqualTo(distance));

    }

    @Test
    @DisplayName("선두 자동차의 거리를 알 수 있다")
    public void leaderDistance() {
        Car car1 = new Car("a", () -> 1);
        Car car2 = new Car("b", () -> 0);
        Car car3 = new Car("c", () -> 1);
        Cars cars = Cars.of(car1, car2, car3);

        cars.move();
        Distance expected = new Distance(1);

        assertThat(cars.leaderDistance()).isEqualTo(expected);
    }

    @Test
    @DisplayName("선두 자동차 리스트를 반환할 수 있다")
    public void leaders() {
        Car car1 = new Car("a", () -> 1);
        Car car2 = new Car("b", () -> 0);
        Car car3 = new Car("c", () -> 1);
        Cars cars = Cars.of(car1, car2, car3);

        cars.move();
        List<Car> leaders = cars.leaders();

        assertThat(leaders).containsExactly(car1, car3);
    }
}