package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

  @DisplayName("자동차대수 3, 시도횟수 5일때 5개의 결과를 반환한다.")
  @Test
  void race() {
    Racing racing = new Racing();
    final List<Result> results = racing.race(new Input(3, 5));

    assertThat(results.size()).isEqualTo(5);
  }

}