package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

  @DisplayName("10보다 크면 예외처리")
  @Test
  void tete() {
    assertThatThrownBy(() -> new RandomNumber(10)).isInstanceOf(IllegalArgumentException.class);
  }

}
