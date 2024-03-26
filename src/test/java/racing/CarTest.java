package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void move() {
        Car car = new Car();

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void stop() {
        Car car = new Car();

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void findSingleWinner() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("meta", 1));
        cars.add(new Car("apple", 4));
        cars.add(new Car("kia", 3));

        List<Car> winners = Car.findWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("apple");

    }

    @Test
    void findMultipleWinners() {
        Car meta = new Car("meta", 4);
        Car apple = new Car("apple", 2);
        Car kia = new Car("	kia", 4);

        List<Car> cars = List.of(meta, apple, kia);
        List<Car> winners = Car.findWinners(cars);

        assertThat(winners)
                .hasSize(2)
                .contains(meta, kia);
    }
}
