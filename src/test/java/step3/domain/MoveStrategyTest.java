package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {

    @DisplayName("MoveForwardStrategy는 움직일 수 있는 상태이기 떄문에 움직일 수 있는 거리는 1이다")
    @Test
    void forwardMoveStrategyTest() {
        MoveStrategy moveStrategy = new MoveForwardStrategy();
        assertThat(moveStrategy.getDistance()).isEqualTo(1);
    }


    @DisplayName("MoveStopStrategy는 움직일 수 없는 상태이기 떄문에 움직일 수 있는 거리는 0이다")
    @Test
    void stopMoveStrategyTest() {
        MoveStrategy moveStrategy = new MoveStopStrategy();
        assertThat(moveStrategy.getDistance()).isEqualTo(0);
    }
}
