package step3.move;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RandomMoveStrategyTest {
    @Test
    @DisplayName("이동을 시도하면 0 또는 1칸만큼 전진한다.")
    void moveTest() {
        // given
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        // when
        int moveAmount = randomMoveStrategy.moveAmount();

        // then
        Assertions.assertThat(moveAmount).isBetween(0, 1);
    }
}
