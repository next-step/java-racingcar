package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UnsignedNumberTest {

  @DisplayName("생성자의 입력값이 null이면 NPE 발생")
  @ParameterizedTest
  @NullSource
  void constructorThrowsNullPointException(String input) {
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(
        () -> new UnsignedNumber(input));
  }

  @DisplayName("생성자의 입력값이 빈값 또는 0이면 NumberFormatException 발생")
  @ParameterizedTest
  @EmptySource
  @ValueSource(strings = {"-1", "-2", "-100", "-1000"})
  void constructorThrowsNumberFormatException(String input) {
    assertThatExceptionOfType(NumberFormatException.class).isThrownBy(
        () -> new UnsignedNumber(input));
  }

  @DisplayName("두 자연수의 덧셈 결과 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1,1,2", "1,1000000,1000001"}, delimiter = ',')
  void sum(String first, String second, Integer expected) {
    assertThat(UnsignedNumber.sum(new UnsignedNumber(first), new UnsignedNumber(second))
        .intValue()).isEqualTo(expected);
  }

  @DisplayName("자연수를 int 타입으로 반환")
  @ParameterizedTest
  @CsvSource(value = {"0,0", "1,1", "2147483647,2147483647"}, delimiter = ',')
  void intValue(String input, Integer expected) {
    assertThat(new UnsignedNumber(input).intValue()).isEqualTo(expected);
  }

  @DisplayName("범위를 벗어난 값을 입력하면 예외를 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"2147483648", "4294967296"})
  void intValueThrowException(String input) {
    assertThatExceptionOfType(NumberFormatException.class).isThrownBy(
        () -> new UnsignedNumber(input));
  }
}