package step3;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {
  RacingGame racingGame;

  @Test
  @DisplayName("게임 진행 테스트")
  void play() {
    racingGame = new RacingGame(2, 10);
    racingGame.play();
  }
}
