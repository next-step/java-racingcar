package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingWinnersTest {

    @DisplayName("자동차 경주 게임을 완료한 후 우승자를 찾는다.")
    @Test
    void find_winners_after_carRacing_is_done() {
        Car car1 = new Car("moon");
        car1.move(4);
        car1.move(4);
        Car car2 = new Car("zi");
        car2.move(4);

        List<Car> winners = CarRacingWinners.findWinners(List.of(car1, car2));

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).isSamePosition(2)).isTrue();
        assertThat(winners.get(0).getCarNameString()).isEqualTo("moon");
    }
}