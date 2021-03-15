package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingGame;

public class RacingGameTest {

  private RacingGame racingGame;

  @BeforeEach
  void setUp() {
    racingGame = new RacingGame();
  }

  @ParameterizedTest(name = "[RacingGame] 입력 받은 댓수 만큼 자동차 생성 테스트")
  @ValueSource(strings = {"pobi,crong,honux"})
  void readyGameTest(String input) {
    racingGame.readyGame(input);
    assertThat(racingGame.inputCars.size()).isEqualTo(3);
  }
}
