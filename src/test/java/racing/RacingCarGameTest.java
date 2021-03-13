package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

  @Test
  void play() {
    RacingCarGame.ready(5, 2)
            .play();
  }

}
