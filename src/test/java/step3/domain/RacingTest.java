package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

  @DisplayName("시도 횟수와 결과의 갯수는 같아야 한다")
  @Test
  void race() {
    Racing racing = new Racing();
    final List<Result> results = racing.race(new Input("pobi,crong,honux", 5));

    assertThat(results.size()).isEqualTo(5);
  }

}