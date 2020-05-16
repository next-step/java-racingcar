package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.ForwardMoveStrategy;
import step3.domain.MoveStrategy;
import step3.domain.StopMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {

    @DisplayName("ForwardMoveStrategy는 움직일 수 있는 상태이기 떄문에 isMovable() 호출시 항상 true를 반환한다")
    @Test
    void forwardMoveStrategyTest() {
        // given
        MoveStrategy moveStrategy = new ForwardMoveStrategy();

        // when
        boolean isMovable = moveStrategy.isMovable();

        // then
        assertThat(isMovable).isTrue();
    }


    @DisplayName("StopMoveStrategy는 움직일 수 없는 상태이기 떄문에 isMovable() 호출시 항상 false를 반환한다")
    @Test
    void stopMoveStrategyTest() {
        // given
        MoveStrategy moveStrategy = new StopMoveStrategy();

        // when
        boolean isMovable = moveStrategy.isMovable();

        // then
        assertThat(isMovable).isFalse();
    }
}
