package step3.domain;

import org.junit.jupiter.api.Test;
import step3.RacingGame;

public class RacingGameTest {

  @Test
  public void start() {
    RacingGame game = new RacingGame();
    game.start(3, 5);
  }

}
