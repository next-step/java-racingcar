package racing.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

  private Game game;

  @BeforeEach
  void init() {
    String carNames = "pobi,crong,honux";
    int roundCount = 3;
    game = new Game(new Participants(carNames), new RoundCount(roundCount));
  }

  @Test
  void test() {
    //TODO
  }
}
