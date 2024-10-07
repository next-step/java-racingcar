package carracing;

import carracing.car.Car;
import carracing.car.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingWinnersTest {

    @DisplayName("자동차 경주 게임을 완료한 후 우승자를 반환한다.")
    @Test
    void return_winners_after_carRacing_is_done() {
        Car moon = new Car("moon");
        Car zi = new Car("zi");
        Cars cars = new Cars(List.of(moon, zi));
        moon.move(4);
        moon.move(4);
        zi.move(4);

        Cars winners = CarRacingWinners.findWinners(cars);

        assertThat(winners.get()).containsExactly(moon);
    }
}