package caculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {


  @Test
  public void splitAndSum_null_또는_빈문자() {
    int result = Calculator.calculate(null);
    assertThat(result).isEqualTo(0);

    result = Calculator.calculate("");
    assertThat(result).isEqualTo(0);
  }

  @Test
  public void splitAndSum_숫자하나() throws Exception {
    int result = Calculator.calculate("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void splitAndSum_쉼표구분자() throws Exception {
    int result = Calculator.calculate("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
    int result = Calculator.calculate("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_custom_구분자() throws Exception {
    int result = Calculator.calculate("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }
}
