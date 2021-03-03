package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StringExpressionTest {

  @Test
  @DisplayName("1 + 3 + 5 는 9다")
  public void calculateTest() {
    int calculate = this.stringExpressionCalculate("1 + 3 + 5");
    assertThat(calculate).isEqualTo(1 + 3 + 5).isEqualTo(9);
  }

  @Test
  @DisplayName("1 + 6 + 은 잘못된 수식이다.")
  public void calculateThrowExceptionTest() {
    assertThatThrownBy(
        () -> new StringExpression("1 + 6 + ")
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName(" 1 * 6 / 3 의 값은 2다")
  public void calculateTest2() {
    int resultValue = stringExpressionCalculate("1 * 6 / 3");
    assertThat(resultValue)
        .isEqualTo(1 * 6 / 3)
        .isEqualTo(2);
  }

  @Test
  @DisplayName(" 15 - 21 * 3 의 값은 -18 이다")
  public void calculateTestMinusResult() {
    int resultValue = stringExpressionCalculate("15 - 21 * 3");
    assertThat(resultValue)
        .isEqualTo((15 - 21) * 3)
        .isEqualTo(-18);
  }

  @Test
  @DisplayName(" 6 + 4 * 3 / 10 의 값은 3 이다")
  public void calculateTotalValue() {
    int resultValue = stringExpressionCalculate("6 + 4 * 3 / 10");
    assertThat(resultValue).isEqualTo(3);
  }

  @Test
  @DisplayName("-1 - -1 - -1 - -1 - -1 의 값은 3이다")
  public void calculateMinusNumber() {
    int resultValue = stringExpressionCalculate("-1 - -1 - -1 - -1 - -1");
    assertThat(resultValue).isEqualTo(3);
  }

  @Test
  @DisplayName("+1 + +1 + +1 의 값은 3이다")
  public void cacluatePlustNumber() {
    int resultValue = stringExpressionCalculate("+1 + +1 + +1");
    assertThat(resultValue).isEqualTo(3);
  }

  private int stringExpressionCalculate(String expression) {
    StringExpression stringExpression = new StringExpression(expression);
    return stringExpression.calculate();
  }

}