package racing.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

  private Game game;

  @BeforeEach
  void init() {
    List<String> carNames = List.of("pobi", "crong", "honux");
    game = new Game(new MovementStrategy(), Participants.from(carNames));
  }

  @Test
  void test() {
    //TODO
  }
}
