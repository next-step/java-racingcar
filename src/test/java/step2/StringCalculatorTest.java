package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringCalculatorTest {

 StringCalculator stringCalculator;

 @BeforeEach
 void setUp() {
  stringCalculator = new StringCalculator();
 }

 @Test
 @DisplayName("덧셈 연산")
 void 덧셈_테스트() {
  assertThat(Calculator.calculate("+", 1, 2)).isEqualTo(3);
 }

 @Test
 @DisplayName("뺄셈 연산")
 void 뺄셈_테스트() {
  assertThat(Calculator.calculate("-", 10, 4)).isEqualTo(6);
 }

 @Test
 @DisplayName("곱셈 연산")
 void 곱셈_테스트() {
  assertThat(Calculator.calculate("*", 2, 4)).isEqualTo(8);
 }

 @Test
 @DisplayName("나눗셈")
 void 나눗셈_테스트() {
  assertThat(Calculator.calculate("/", 4, 2)).isEqualTo(2);
 }

 @ParameterizedTest
 @DisplayName("입력값이 null이거나 빈 문자열인 경우 예외 처리")
 @CsvSource(value = {"null : 입력값이 없습니다.", "' ': 입력값이 없습니다."}, delimiter = ':')
 void 빈문자열_테스트(String expression, String message) {
  assertThatThrownBy(() -> assertThat(expression)
          .isInstanceOf(IllegalArgumentException.class))
          .overridingErrorMessage(message);
 }

 @ParameterizedTest
 @DisplayName("사칙연산 기호가 아닌 경우 false 반환")
 @ValueSource(strings = {"&"})
 void 사칙연산_기호_유효성_테스트(String operator) {
  assertFalse(stringCalculator.isOperator(operator));
 }

 @ParameterizedTest
 @DisplayName("사칙연산을 모두 포함하는 기능 구현")
 @ValueSource(strings = {"2 + 3 * 4 / 2"})
 void 사칙연산_모두_포함_테스트(String data) {
  assertThat(stringCalculator.calculator(data)).isEqualTo(10);
 }
}
