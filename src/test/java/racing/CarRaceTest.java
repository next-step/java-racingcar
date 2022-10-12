package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {
    @Test
    void test_create_with_empty_cars() {
        assertThatThrownBy(() -> {
            CarRace carRace = new CarRace(List.of());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_round() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        CarRace carRace = new CarRace(cars);
        carRace.round(() -> true);

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
        CarRace carRace = new CarRace(cars);
        assertThat(carRace.getWinners()).contains(winner1, winner2);
    }
}
