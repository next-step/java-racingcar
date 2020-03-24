package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRuleTest {
    @Test
    @DisplayName("입력 받은 숫자가 게임 규칙에 맞아 이동 여부가 True인지 테스트")
    void isNumberCanMoveTrue() {
        assertThat(GameRule.isNumberCanMove(GameRule.NUMBER_CAN_MOVE)).isTrue();
    }

    @Test
    @DisplayName("입력받은 숫자가 게임 규칙에 맞지 않아 이동 여부가 False인지 테스트")
    void isNumberCanMoveFalse() {
        int value = 3;
        assertThat(GameRule.isNumberCanMove(value)).isFalse();
    }

    @Test
    @DisplayName("입력받은 숫자 List 중 최대 숫자를 잘 고르는 지 테스트")
    void getMaxNumber() {
        List numberList = Arrays.asList(3, 4, 9);
        assertThat(GameRule.getMaxPosition(numberList)).isEqualTo(9);
    }
}
