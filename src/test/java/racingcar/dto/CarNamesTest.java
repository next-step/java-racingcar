package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

  @Test
  @DisplayName("빈 값이면 예외를 던진다")
  void throwIfEmpty() {
    assertThatThrownBy(() -> new CarNames(""))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("구분자만 있는 빈 값이면 예외를 던진다")
  void throwIfNull() {
    assertThatThrownBy(() -> new CarNames(",,,"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}