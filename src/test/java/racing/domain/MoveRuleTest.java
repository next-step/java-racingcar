package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class MoveRuleTest {

    @Test
    void 주입된_이동전략에_따라_이동_가능성을_판단한다() {
        MoveRule moveRule = new MoveRule(7);
        assertThat(moveRule.isMovable(6)).isFalse();
    }
}
