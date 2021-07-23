package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultViewTest {

  public static final String NEW_LINE = System.lineSeparator();
  private static final String NEW_LINE_TWICE = NEW_LINE.repeat(2);

  private ResultView resultView;

  @BeforeEach
  void init() {
    resultView = new ResultView();
  }

  @Test
  void concat() {
    final String actual = resultView.concat(List.of(
        new Result(List.of(1, 0, 1)),
        new Result(List.of(2, 1, 2)),
        new Result(List.of(3, 1, 2))
    ));

    final String expected = new StringBuilder("실행 결과" + NEW_LINE)
        .append("-").append(NEW_LINE)
        .append(NEW_LINE)
        .append("-").append(NEW_LINE_TWICE)
        .append("--").append(NEW_LINE)
        .append("-").append(NEW_LINE)
        .append("--").append(NEW_LINE_TWICE)
        .append("---").append(NEW_LINE)
        .append("-").append(NEW_LINE)
        .append("--").toString();

    assertThat(actual).isEqualTo(expected);

  }
}