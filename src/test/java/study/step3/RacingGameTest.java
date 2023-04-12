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

  @DisplayName("자동차 게임 유저 입력 부분 테스트")
  @Test
  public void printGameReadyTxtTest() {
    OutputStream out = createOutputStream();
    String input = "3\n5\n";
    setSystemIn(input);
    RacingGame game = new RacingGame();
    game.ready();
    assertThat(out.toString()).isEqualTo("자동차 대수는 몇 대 인가요?\n시도할 회수는 몇 회 인가요?\n");
  }

  @DisplayName("자동차 게임 유저 입력 부분 에러테스트")
  @Test
  public void printGameReadyTxtErrorTest() {
    String input = "a\n5\n";
    createOutputStream();
    setSystemIn(input);
    RacingGame game = new RacingGame();
    assertThatThrownBy(() -> game.ready())
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("숫자만 입력해주세요");

  }

  @DisplayName("자동차 게임 준비 없이 시작 에러 테스트")
  @Test
  public void notReadyGameStartErrorTest() {
    String input = "3\n5\n";
    createOutputStream();
    setSystemIn(input);
    RacingGame game = new RacingGame();
    assertThatThrownBy(() -> game.start())
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("게임 준비가 되지 않았습니다.");
  }

  @DisplayName("자동차 게임 준비 > 시작 테스트")
  @Test
  public void readyGameStartErrorTest() {
    String input = "3\n5\n";
    createOutputStream();
    setSystemIn(input);
    RacingGame game = new RacingGame();
    game.ready();
    game.start();
    assertThat(game.isFinish()).isEqualTo(true);
  }
  private OutputStream createOutputStream() {
    OutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    return out;
  }
  private void setSystemIn(String input) {
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
  }
}
