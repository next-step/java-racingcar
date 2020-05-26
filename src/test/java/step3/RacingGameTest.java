package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {
  RacingGame racingGame;

  @ParameterizedTest
  @CsvSource({"test1 test2 test3, 3"})
  @DisplayName("게임 진행 테스트")
  void play(String carNameInput, int time) {
    racingGame = new RacingGame(carNameInput.split(" "), time);
    for (int i = 0; i < 100; i++) {
      racingGame.play();
    }
  }
}
