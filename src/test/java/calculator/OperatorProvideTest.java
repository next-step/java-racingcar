package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorProvideTest {

  @Test
  public void plusProvideTest() {
    Operator operator = Operator.get("+");
    assertThat(operator).isEqualTo(Operator.PLUS);
  }

  @Test
  public void MultiplyProvideTest() {
    Operator operator = Operator.get("*");
    assertThat(operator).isEqualTo(Operator.MULTIPLY);
  }

  @Test
  @DisplayName("사칙연산이 아닌 연산자를 요청하면 IllegalArgumentsException 을 발생시킨다.")
  public void operatorProvideExceptionTest() {
    String wrongOperator = "^";
    assertThatThrownBy(() -> Operator.get(wrongOperator))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(wrongOperator);
  }
}