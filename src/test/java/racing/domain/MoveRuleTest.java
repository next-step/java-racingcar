package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class MoveRuleTest {

    @Test
    void 주입된_이동전략에_따라_이동_가능성을_판단한다() {
        MoveRule moveRule = new MoveRule() {
            private static final int MOVE_CONDITION = 4;
            private static final int NON_MOVABLE_VALUE = 1;

            @Override
            public int makeValue() {
                return NON_MOVABLE_VALUE;
            }

            @Override
            public boolean isMovable() {
                return makeValue() >= MOVE_CONDITION;
            }
        };
        assertThat(moveRule.isMovable()).isFalse();
    }
}
