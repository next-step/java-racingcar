package step3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

  private Result result;

  @BeforeEach
  void init() {
    result = new Result(List.of(1, 0, 1));
  }

  @DisplayName("3대의 자동차가 1번 움직였을 때 위치가 1,0, 1일떄 실행 결과는 다음과 같다.")
  @Test
  void log() {
    final String log = result.log();

    Assertions.assertThat(log).isEqualTo(new StringBuilder()
        .append("--").append("\n")
        .append("-").append("\n")
        .append("--")
        .toString());
  }
}