package carracing;

import carracing.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingWinnersTest {

    @DisplayName("자동차 경주 게임을 완료한 후 우승자를 찾는다.")
    @Test
    void find_winners_after_carRacing_is_done() {
        Car moon = new Car("moon");
        moon.move(4);
        moon.move(4);
        Car zi = new Car("zi");
        zi.move(4);

        List<Car> winners = CarRacingWinners.findWinners(List.of(moon, zi));

        assertThat(winners).containsExactly(moon);
    }
}