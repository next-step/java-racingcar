package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveRuleTest {

    @Test
    @DisplayName("입력받은 수가 4 미만일 경우 움직일 수 없다.")
    void canMove_false() {
        assertThat(RandomMoveRule.canMove(3)).isFalse();
    }

    @Test
    @DisplayName("입력받은 수가 4 이상일 경우 움직일 수 있다.")
    void canMove_true() {
        assertThat(RandomMoveRule.canMove(4)).isTrue();
    }
}
