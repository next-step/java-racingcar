package carrace;

import carrace.domain.Car;
import carrace.domain.RaceWinner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RaceWinnerTest {

    @Test
    @DisplayName("우승자 선정")
    void checkWinner() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1", 2));
        cars.add(new Car("test2", 3));
        cars.add(new Car("test3", 4));

        RaceWinner raceWinner = new RaceWinner();
        raceWinner.confirmWinners(cars);

        assertThat(raceWinner.getWinners()).isEqualTo(List.of(cars.get(2)));
    }

    @Test
    @DisplayName("공동 우승자 선정")
    void checkWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1", 2));
        cars.add(new Car("test2", 4));
        cars.add(new Car("test3", 4));

        RaceWinner raceWinner = new RaceWinner();
        raceWinner.confirmWinners(cars);

        assertThat(raceWinner.getWinners()).isEqualTo(List.of(cars.get(1), cars.get(2)));
    }

    @Test
    @DisplayName("자동차가 모두 움직이지 않았을 때 우승자 선정")
    void checkNotMovedWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1", 0));
        cars.add(new Car("test2", 0));
        cars.add(new Car("test3", 0));

        RaceWinner raceWinner = new RaceWinner();
        raceWinner.confirmWinners(cars);

        assertThat(raceWinner.getWinners()).isEqualTo(List.of(cars.get(0), cars.get(1), cars.get(2)));
    }
}