package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRacingRuleTest {

  @DisplayName("이동할 수 있는지 확인")
  @Test
  void canMoveTest() {
    RandomRacingRule racingRule = new RandomRacingRule();
    assertThat(racingRule.canMove(5)).isTrue();
  }

  @DisplayName("이동할 수 없는지 확인")
  @Test
  void cannotMoveTest() {
    RandomRacingRule racingRule = new RandomRacingRule();
    assertThat(racingRule.canMove(1)).isFalse();
  }

}
