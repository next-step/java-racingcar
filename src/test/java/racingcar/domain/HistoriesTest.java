package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.RoundCount;
import racingcar.domain.strategy.FixedMoving;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HistoriesTest {

    @Test
    @DisplayName("우승 자동차가 하나일 경우 하나를 반환한다.")
    void winnerCar() {
        Car tim = new Car("tim");
        Car tommy = new Car("tommy", FixedMoving.alwaysGo);
        tommy.move();

        List<Car> cars = new ArrayList<>();
        cars.add(tim);
        cars.add(tommy);

        History history = new History(new Round(new RoundCount(1)), cars);

        Histories histories = new Histories();
        histories.add(history);

        assertThat(histories.findWinners()).containsExactly(tommy);
    }

    @Test
    @DisplayName("우승자 자동차가 둘일 경우 두개 다 반환한다.")
    void winnerCars() {
        Car tim = new Car("tim");
        Car tommy = new Car("tommy", FixedMoving.alwaysGo);
        tommy.move();
        Car anna = new Car("anna", FixedMoving.alwaysGo);
        anna.move();

        List<Car> cars = new ArrayList<>();
        cars.add(tim);
        cars.add(tommy);
        cars.add(anna);

        History history = new History(new Round(new RoundCount(1)), cars);

        Histories histories = new Histories();
        histories.add(history);

        assertThat(histories.findWinners()).containsExactly(tommy, anna);
    }
}