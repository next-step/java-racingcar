package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

  public static final String NEWLINE = System.lineSeparator();

  private Result result;

  @BeforeEach
  void init() {
    result = new Result(
        List.of(
            new Car(new Name("pobi"), 1),
            new Car(new Name("crong"), 0),
            new Car(new Name("honux"), 1)
        )
    );
  }

  @DisplayName("3대의 자동차가 1번 움직였을 때 위치가 1,0, 1일떄 실행 결과는 다음과 같다.")
  @Test
  void log() {
    final String actual = result.log();

    final String expected = "pobi : -" + NEWLINE
        + "crong : " + NEWLINE
        + "honux : -";

    assertThat(actual).isEqualTo(expected);
  }
}