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
        List<Car> cars = List.of(
                new Car("car1", () -> true),
                new Car("car2", () -> true)
        );
        CarRace carRace = new CarRace(cars);
        carRace.round();

        for (Car car : cars) {
            assertThat(car.getMoves()).isEqualTo(1);
        }
    }

    @Test
    void test_get_winner() {
        Car winner1 = new Car("car1", () -> true);
        Car winner2 = new Car("car1", () -> true);
        Car loser1 = new Car("car1", () -> false);
        List<Car> cars = List.of(winner1, winner2, loser1);

        CarRace carRace = new CarRace(cars);
        carRace.round();

        assertThat(carRace.getWinners()).contains(winner1, winner2);
    }
}
