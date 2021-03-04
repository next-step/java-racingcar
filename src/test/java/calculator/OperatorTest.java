package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

  @Test
  @DisplayName("Operator Plus 테스트")
  public void plusTest() {
    int val = Operator.PLUS.calculate(1, 1);
    assertEquals(1 + 1, val);
  }

  @Test
  @DisplayName("Operator Minus 테스트")
  public void minusTest() {
    int val = Operator.MINUS.calculate(3, 1);
    assertEquals(3 - 1, val);
  }

  @Test
  @DisplayName("Operator multiply 테스트")
  public void multiplyTest() {
    int val = Operator.MULTIPLY.calculate(5, 4);
    assertEquals(5 * 4, val);
  }

  @Test
  @DisplayName("Operator DIVIDE 테스트")
  public void divideTest() {
    int val = Operator.DIVIDE.calculate(10, 2);
    assertEquals(10 / 2, val);
  }

}