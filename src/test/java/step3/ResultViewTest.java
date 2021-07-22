package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultViewTest {

  private ResultView resultView;

  @BeforeEach
  void init() {
    resultView = new ResultView();
  }

  @Test
  void concat() {
    final String text = resultView.concat(List.of(
        new Result(List.of(1, 0, 1)),
        new Result(List.of(2, 1, 2)),
        new Result(List.of(3, 1, 2))
    ));

    assertThat(text).isEqualTo(
        new StringBuilder()
            .append("--").append("\n")
            .append("-").append("\n")
            .append("--").append("\n\n")
            .append("---").append("\n")
            .append("--").append("\n")
            .append("---").append("\n\n")
            .append("----").append("\n")
            .append("--").append("\n")
            .append("---").toString()
    );

  }
}