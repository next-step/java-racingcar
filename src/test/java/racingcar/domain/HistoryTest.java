package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.RoundCount;
import racingcar.domain.strategy.FixedMoving;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HistoryTest {

    @Test
    @DisplayName("top 자동차가 하나일 경우 하나를 반환한다.")
    void topCar() {
        List<Car> cars = new ArrayList<>();

        Car tim = new Car("tim", 3);
        cars.add(tim);
        cars.add(new Car("tommy", 2));

        History history = new History(new Round(new RoundCount(1)), cars);

        assertThat(history.topCars()).containsExactly(tim);
    }

    @Test
    @DisplayName("top 자동차가 둘일 경우 두개 다 반환한다.")
    void topCars() {
        List<Car> cars = new ArrayList<>();
        Car tim = new Car("tim", 3);
        Car anna = new Car("anna", 3);
        cars.add(tim);
        cars.add(anna);
        cars.add(new Car("tommy", 2));

        History history = new History(new Round(new RoundCount(1)), cars);

        assertThat(history.topCars()).containsExactly(tim, anna);
    }
}