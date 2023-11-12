package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoveStrategyTest {

    @DisplayName("Random을 인자로 받은 CarMoveStrategy의 결과는 0~9의 값을 리턴한다.")
    @Test
    void car_move_strategy_result() {
        // given
        CarMoveStrategy carMoveStrategy = new CarMoveStrategy();

        // when
        int result = carMoveStrategy.getMoveSource();

        // then
        assertThat(result).isBetween(0, 9);
    }
}
