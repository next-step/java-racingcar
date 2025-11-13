package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

  private final int TRY_CNT = 5;
  private List<CarName> carNames;
  private Game game;

  @BeforeEach
  void init() {
    carNames = List.of(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
    game = new Game(new MovementStrategy(0, 9), carNames, TRY_CNT);
  }

  @Test
  void gameContainsNCars() {
    assertThat(game.getCars().size()).isEqualTo(carNames.size());
  }

  @Test
  void gameContainsTryCnt() {
    assertThat(game.getTryCnt()).isEqualTo(TRY_CNT);
  }

  @Test
  void gamePlayTryCnt() {
    game.play();
    for (Car car : game.getCars()) {
      assertThat(car.getPosition()).isBetween(0, TRY_CNT);
    }
  }
}
