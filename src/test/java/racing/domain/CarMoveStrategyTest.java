package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoveStrategyTest {

    @DisplayName("Random을 인자로 받은 CarMoveStrategy의 결과는 0~9의 값을 리턴한다.")
    @Test
    void car_move_strategy_result() {
        // given
        Random random = new Random(); // default seed : System.nanoTime()
        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(random);

        // when
        int result = carMoveStrategy.getResult();

        // then
        assertThat(result).isBetween(0, 9);
    }
}
