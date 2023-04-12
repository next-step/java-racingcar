package step3.move;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StopMoveStrategyTest {

    @Test
    @DisplayName("이동을 시도하면 0칸 전진한다")
    void moveTest() {
        // given
        MoveStrategy randomMoveStrategy = new StopMoveStrategy();

        // when
        int moveAmount = randomMoveStrategy.moveAmount();

        // then
        Assertions.assertThat(moveAmount).isEqualTo(0);
    }

}
