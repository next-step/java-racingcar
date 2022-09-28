package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    @DisplayName("이동 횟수를 음수로 넘기면 테스트가 실패한다.")
    void 이동_횟수_음수_실패() {
        Assertions.assertThatThrownBy(() -> RacingGame.race(3, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수값만 입력가능합니다.");
    }
}
