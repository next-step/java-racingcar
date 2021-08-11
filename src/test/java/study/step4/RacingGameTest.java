package study.step4;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step4.model.RacingGame;
import study.step4.model.strategy.RandomMoveStrategy;
import study.step4.view.ResultView;

public class RacingGameTest {

  @DisplayName("Car Racing Game 진행 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"car1", "car1,car2", "car1,car2,car3"})
  public void carRacingGameStartTest(String carNames) {
    final int CAR_GAME_ROUND = 5;
    RacingGame racingGame = new RacingGame(carNames, CAR_GAME_ROUND);
    assertDoesNotThrow(() -> racingGame.start(new RandomMoveStrategy(), new ResultView()));
  }
}
