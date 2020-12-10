package step3.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRacingRuleTest {

  @Test
  void getTargetNumberTest() {
    RacingRule racingRule = new RandomRacingRule(10);
    assertThat(racingRule.getTargetNumber()).isLessThan(10);
  }
}
