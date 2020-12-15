package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.rule.RandomMoveRule;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.rule.RandomMoveRule.NUMBER_CAN_MOVE;

public class RandomMoveRuleTest {
    private static final int NUMBER_CAN_NOT_MOVE = 3;

    @Test
    @DisplayName("입력받은 수가 4 미만일 경우 움직일 수 없다.")
    void canMove_false() {
        assertThat(RandomMoveRule.canMoveWithNumber(NUMBER_CAN_NOT_MOVE)).isFalse();
    }

    @Test
    @DisplayName("입력받은 수가 4 이상일 경우 움직일 수 있다.")
    void canMove_true() {
        assertThat(RandomMoveRule.canMoveWithNumber(NUMBER_CAN_MOVE)).isTrue();
    }
}
