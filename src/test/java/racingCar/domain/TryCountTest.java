package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

  @DisplayName("0일때 실행하면 예외 발생")
  @Test
  void zero_exception() {
    TryCount tryCount = new TryCount(0);
    assertThatThrownBy(() -> tryCount.race()).isInstanceOf(AlreadyEndRaceException.class);
  }

}