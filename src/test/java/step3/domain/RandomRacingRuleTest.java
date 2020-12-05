package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRacingRuleTest {

  @DisplayName("이동할 수 있는 자격을 확인")
  @Test
  void canMoveTest() {
    RandomRacingRule racingRule = new RandomRacingRule();
    assertThat(racingRule.canMove(5)).isTrue();
    assertThat(racingRule.canMove(1)).isFalse();
  }

}
