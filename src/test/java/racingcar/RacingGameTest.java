package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;

public class RacingGameTest {

  private RacingGame racingGame;

  @BeforeEach
  void setUp() {
    racingGame = new RacingGame();
  }

  @Test
  @DisplayName("[RacingGame] 입력 받은 댓수 만큼 자동차 생성 테스트")
  void readyGameTest() {
    assertThat(racingGame.cars.size()).isZero();
    racingGame.readyGame(4);
    assertThat(racingGame.cars.size()).isEqualTo(4);
  }

}
