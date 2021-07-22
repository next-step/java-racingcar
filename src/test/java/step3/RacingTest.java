package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

  @DisplayName("값을 입력하지 않았을 경우 0개의 결과를 반환한다")
  @Test
  void race() {
    Racing racing = new Racing();
    final List<Result> results = racing.race(new Input());

    assertThat(results.size()).isEqualTo(0);
  }

}