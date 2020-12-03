package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingRuleTest {

  @Test
  public void 랜덤_0_9_숫자_구하기() {
    assertThat(RacingRule.getRandomNumber()).isBetween(0, 9);
  }

}
