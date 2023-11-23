package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("경기 종료 후, 우승자일 경우 저장한다.")
    void findWinners() {
        Car car1 = new Car("망고", 3);
        Car car2 = new Car("오렌지", 1);
        Winners winners = new Winners();

        winners.addWinner(car1, 3);
        winners.addWinner(car2, 3);

        assertThat(winners.winners()).containsExactly("망고");
    }
}
