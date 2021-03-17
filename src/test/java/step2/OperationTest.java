package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {

  @ParameterizedTest
  @DisplayName("연산 기능 테스트")
  @CsvSource(value = { "+,3", "-,1", "/,2", "*,2" })
  void calculation(String symbol, int expected) {
    // given

    // when
    int result = Operation.of(symbol).calculation(2, 1);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("0 나누기 예외 테스트")
  void divisionByZero() {
    assertThatThrownBy(() -> Operation.of("/").calculation(1, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Cannot be divided by 0.");
  }
}