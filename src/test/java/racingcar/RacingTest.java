package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.TryMovingCarException;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

  @Test
  @DisplayName("시도 횟수가 없으면 차를 움직일 수 없다")
  public void tryMoveWhenRemainingTryCountOverZero() throws Exception {
    int tryCount = 1;
    RacingRule racingRule = new RacingRule(3, tryCount);
    Racing racing = new Racing(racingRule);

    int remainTryCount = racing.getRemainTryCount();
    assertRemainTryCount(racing, remainTryCount);

    racing.tryMoveCars();
    assertRemainTryCount(racing, remainTryCount - 1);

    assertThatThrownBy(racing::tryMoveCars)
        .isInstanceOf(TryMovingCarException.class)
        .hasMessageContaining("남은 이동횟수가 없습니다.");

  }

  private void assertRemainTryCount(Racing racing, int expected) {
    assertThat(racing.getRemainTryCount()).isEqualTo(expected);
  }
}
