package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingTest {

  @Test
  void 자동차_객체_생성() {
    assertThat(new Racing(3).getCars().size()).isEqualTo(3);

  }

}