package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveRuleTest {
    @Test
    @DisplayName("입력 받은 숫자가 게임 규칙에 맞아 이동 여부가 True인지 테스트")
    void isNumberCanMoveTrue() {
        assertThat(RandomMoveRule.isNumberCanMove(RandomMoveRule.NUMBER_CAN_MOVE)).isTrue();
    }

    @Test
    @DisplayName("입력받은 숫자가 게임 규칙에 맞지 않아 이동 여부가 False인지 테스트")
    void isNumberCanMoveFalse() {
        int value = 3;
        assertThat(RandomMoveRule.isNumberCanMove(value)).isFalse();
    }
}
