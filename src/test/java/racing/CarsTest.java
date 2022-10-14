package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void test_create_with_empty_cars() {
        assertThatThrownBy(() -> {
            Cars carRace = new Cars(List.of());
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Cars carRace = new Cars(new String[]{});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_move() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        Cars carRace = new Cars(cars);
        carRace.move(() -> true);

        for (Car car : cars) {
            assertThat(car.hasDistance(new CarDistance(1))).isTrue();
        }
    }

    @Test
    void test_get_winner() {
        Car winner1 = new Car("car1", 1);
        Car winner2 = new Car("car2", 1);
        Car loser1 = new Car("car3", 0);
        List<Car> cars = List.of(winner1, winner2, loser1);
        Cars carRace = new Cars(cars);
        assertThat(carRace.getWinners()).contains(winner1, winner2);
    }
}
