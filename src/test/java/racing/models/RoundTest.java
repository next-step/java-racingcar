package racing.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    @Test
    @DisplayName("인자로 받은 List<Car> 객체를 deep copy 한다.")
    void createFrom() {
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        final Round round = Round.createFrom(cars);
        final List<Car> roundCars = round.getCars();

        assertThat(roundCars).isNotEqualTo(cars);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(roundCars.get(i)).isNotEqualTo(cars.get(i));
            assertThat(roundCars.get(i).getDistance()).isEqualTo(cars.get(i).getDistance());
        }
    }

    void mustMove(Car car, int count) {
        final int mustMoveValue = 9;

        for (int i = 0; i < count; i++) {
            car.tryMove(() -> mustMoveValue);
        }
    }

    @Test
    @DisplayName("우승자(distance가 가장 큰 Car 객체)를 구한다.")
    void getWinners() {
        final Car pobi = new Car("pobi");
        final Car crong = new Car("crong");
        final Car honux = new Car("honux");

        mustMove(pobi, 5);
        mustMove(crong, 3);
        mustMove(honux, 1);

        final Round round = Round.createFrom(Arrays.asList(pobi, crong, honux));

        final List<String> expectedNames = Stream.of(pobi).map(Car::getName).collect(Collectors.toList());
        final List<String> winnerNames = round.getWinners().stream().map(e -> e.getName()).collect(Collectors.toList());

        // assert
        assertThat(winnerNames).containsAll(expectedNames);
    }

    @Test
    @DisplayName("우승자(distance가 가장 큰 Car 객체)를 구한다. 한 명 이상일 수 있다.")
    void getWinners2() {
        final Car pobi = new Car("pobi");
        final Car crong = new Car("crong");
        final Car honux = new Car("honux");

        mustMove(pobi, 5);
        mustMove(crong, 5);
        mustMove(honux, 1);

        final Round round = Round.createFrom(Arrays.asList(pobi, crong, honux));

        final List<String> expectedNames = Stream.of(pobi, crong).map(Car::getName).collect(Collectors.toList());
        final List<String> winnerNames = round.getWinners().stream().map(e -> e.getName()).collect(Collectors.toList());

        // assert
        assertThat(winnerNames).containsAll(expectedNames);
    }
}
