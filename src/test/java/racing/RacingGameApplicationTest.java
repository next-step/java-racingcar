package racing;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing.domain.RoundCount;

class RacingGameApplicationTest {

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