package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.domain.racingGame.GameConsole;

public class GameConsoleTest {

  private GameConsole console;


  @DisplayName("게임  텍스트 출력하기 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?"})
  public void printTest(String input) {
    OutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    console = new GameConsole();
    console.print(input);
    assertThat(out.toString()).isEqualTo(input + "\n");
  }


  @DisplayName("게임  텍스트 입력 받기 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1,1", "2,2", "3,3"})
  public void inputCarNumTest(String carNum, int expect) {
    setSystemIn(carNum);
    console = new GameConsole();
    assertThat(console.inputInt()).isEqualTo(expect);
  }


  private void setSystemIn(String input) {
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
  }
}
