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
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = new Car();

        car.move(3);
        assertThat(car.getPosition()).isZero();
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
    void findTwoWinners() {
        Car meta = new Car("meta", 4);
        Car apple = new Car("apple", 2);
        Car kia = new Car("kia", 4);

        List<Car> cars = List.of(meta, apple, kia);
        List<Car> winners = Car.findWinners(cars);

        assertThat(winners)
                .hasSize(2)
                .contains(meta, kia);
    }

    @Test
    void findMultipleWinners() {
        Car a = new Car("a", 1);
        Car b = new Car("b", 2);
        Car c = new Car("c", 2);
        Car d = new Car("d", 2);

        List<Car> cars = List.of(a,b,c,d);
        List<Car> winners = Car.findWinners(cars);

        assertThat(winners)
                .hasSize(3)
                .contains(b, c, d);
    }
}
