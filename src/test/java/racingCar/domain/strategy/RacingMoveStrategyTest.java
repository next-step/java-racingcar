package racingCar.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingMoveStrategyTest {

    @DisplayName("이동전략 객체 생성")
    @Test
    void createMoveStrategy(){
        MoveStrategy moveStrategy = new RacingMoveStrategy();
        assertThat(moveStrategy).isInstanceOf(RacingMoveStrategy.class);
    }

}
