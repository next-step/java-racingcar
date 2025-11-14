package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

  private final int TRY_CNT = 5;
  private Game game;

  @BeforeEach
  void init() {
    List<CarName> carNames = List.of(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
    game = new Game(new MovementStrategy(0, 9), new Participants(carNames), TRY_CNT);
  }

  @Test
  void gameContainsTryCnt() {
    assertThat(game.getTryCnt()).isEqualTo(TRY_CNT);
  }

  @Test
  void gameReturnsWinner(){
    List<Car> winners = game.getWinners();
    assertThat(winners).isNotEmpty();
  }
}
