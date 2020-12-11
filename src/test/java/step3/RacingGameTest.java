package step3;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

  @Test
  public void start() {
    RacingGame game = new RacingGame("pobi,crong,honux", 5);
    game.race();
  }

}
