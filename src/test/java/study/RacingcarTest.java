package study;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingcarTest {

    @Test
    void racingCar() {

        Racing racing = new Racing();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("apple", 10));
        cars.add(new Car("banana", 5));

        int bestPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);

        var winners = cars.stream()
                .filter(it -> it.getPosition() == bestPosition)
                .collect(Collectors.toList());

        assertThat(winners.get(0).getName()).isEqualTo("apple");
    }
}
