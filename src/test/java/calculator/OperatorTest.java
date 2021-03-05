package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperatorTest {

  @ParameterizedTest(name = "[Operator] 덧셈 테스트 - {index}")
  @CsvSource(value = {"2,3,5", "1,5,6", "4,5,9"}, delimiter = ',')
  void addTest(int num1, int num2, int expected) {
    assertThat(Operator.operate(num1, num2, "+")).isEqualTo(expected);
  }

  @ParameterizedTest(name = "[Operator] 뺄셈 테스트 - {index}")
  @CsvSource(value = {"5,2,3", "6,1,5", "9,3,6"}, delimiter = ',')
  void subTest(int num1, int num2, int expected) {
    assertThat(Operator.operate(num1, num2, "-")).isEqualTo(expected);
  }

  @ParameterizedTest(name = "[Operator] 곱셈 테스트 - {index}")
  @CsvSource(value = {"2,5,10", "1,5,5", "2,3,6"}, delimiter = ',')
  void mulTest(int num1, int num2, int expected) {
    assertThat(Operator.operate(num1, num2, "*")).isEqualTo(expected);
  }

  @ParameterizedTest(name = "[Operator] 나눗셈 테스트 - {index}")
  @CsvSource(value = {"8,4,2", "12,3,4", "9,3,3"}, delimiter = ',')
  void divTest(int num1, int num2, int expected) {
    assertThat(Operator.operate(num1, num2, "/")).isEqualTo(expected);
  }

  @ParameterizedTest(name = "[Operator] 사칙연산 기호가 아닌 경우 예외처리 테스트 - {index}")
  @CsvSource(value = {"8,4,@", "12,3,#", "9,3,&"}, delimiter = ',')
  void operatorExceptionTest(int num1, int num2, String op) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Operator.operate(num1, num2, op);
    });
  }
}
