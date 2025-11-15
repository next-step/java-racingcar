package racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.exception.RacingException;

class CarNameTest {

  @ParameterizedTest
  @CsvSource({"abcdef", "verylongname"})
  @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
  void carNameShouldThrowExceptionWhenMoreThan5(String name) {
    assertThatThrownBy(() -> new CarName(name))
        .isInstanceOf(RacingException.class)
        .hasMessageContaining("5자");
  }

  @Test
  @DisplayName("이름이 0자인경우 예외 발생")
  void carNameShouldThrowExceptionWhenLessThan0() {
    assertThatThrownBy(() -> new CarName(""))
        .isInstanceOf(RacingException.class)
        .hasMessageContaining("비어");
  }

}