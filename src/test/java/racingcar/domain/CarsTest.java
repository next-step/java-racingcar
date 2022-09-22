package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @DisplayName("여러 자동차를 등록한다.")
    @Test
    void createCars() {
        Cars cars = CarFactory.createCars("noose,pobi,honux");

        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("우승자를 찾을 수 있다.")
    @Test
    void findWinners() {
        Cars cars = CarFactory.createCars("noose");
        MoveStrategy forward = () -> true;
        cars.move(forward);
        cars.move(forward);

        cars.add(new Car("pobi"));
        cars.add(new Car("honux"));

        int max = cars.getElements()
                .stream()
                .mapToInt(Car::position)
                .max()
                .getAsInt();

        List<Car> winners = cars.getElements()
                .stream()
                .filter(car -> car.position() == max)
                .collect(Collectors.toList());

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.size()).isEqualTo(1);
    }
}