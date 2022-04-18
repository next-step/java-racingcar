package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TryCountTest {

  @Test
  void race_실행_확인() {
    TryCount tryCount = new TryCount(1);
    tryCount.race();
    assertThat(tryCount.isFinished()).isTrue();
  }
}
