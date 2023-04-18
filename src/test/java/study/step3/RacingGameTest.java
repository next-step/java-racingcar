package study.step3;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.racingGame.RacingGame;

public class RacingGameTest {

  @DisplayName("자동차 게임 준비 없이 시작 에러 테스트")
  @Test
  public void notReadyGameStartErrorTest() {
    RacingGame game = new RacingGame();
    assertThatThrownBy(() -> game.race())
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("게임 준비가 되지 않았습니다.");
  }

  @DisplayName("자동차 게임 준비 > 시작 테스트")
  @Test
  public void readyGameStartTest() {
    RacingGame game = new RacingGame();
    game.ready(3, 5);
    do {
      game.race();
    } while (!game.isFinish());
    assertThat(game.isFinish()).isEqualTo(true);
  }
}
