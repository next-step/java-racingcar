package racing.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingGameTest {

  @Test
  void playRepeatNTimes() {
    int EXPECTED = 10;
    int realRepeated = 0;
    RoundCount round = new RoundCount(EXPECTED);
    while (round.canRace()) {
      round.doRace();
      realRepeated += 1;
    }
    assertThat(realRepeated).isEqualTo(EXPECTED);
  }
}