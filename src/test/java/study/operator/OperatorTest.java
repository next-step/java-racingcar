package study.operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

  @ParameterizedTest
  @CsvSource(value = {"+,12", "-,8", "*,20", "/,5"})
  @DisplayName("사칙연산 함수 기능을 테스트한다.")
  void operatorFuncTest(String operator, int expected) {
    int num1 = 10;
    int num2 = 2;

    assertThat(Operator.OperatorCompute(num1, num2, operator)).isEqualTo(expected);
  }

  @Test
  @DisplayName("사칙연산이 아닌 연산자를 입력할 경우 에러를 리턴한다.")
  void validateOperatorTest() {
    String operator = "=";

    assertThatThrownBy(() -> Operator.get(operator))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching("사칙연산 기호가 아닙니다.");
  }
}