package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

  private Game game;

  @BeforeEach
  void init() {
    List<String> carNames = List.of("pobi", "crong", "honux");
    game = new Game(new MovementStrategy(0, 9), Participants.from(carNames));
  }

  @Test
  void gameReturnsWinner(){
    List<String> winners = game.getWinners();
    assertThat(winners).isNotEmpty();
  }
}
