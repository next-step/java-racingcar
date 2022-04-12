package camp.nextstep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

  @Test
  public void 빈문자열_또는_null() {
    assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
  }

  @Test
  public void 숫자하나_해당숫자반환() {
    assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
  }

  @Test
  public void 쉼표_구분자() {
    assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
  }

  @Test
  public void 쉼표_또는_콜론_구분자() {
    assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
  }

  @Test
  public void 커스텀_구분자() {
    assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
  }

  @Test
  public void 음수_쉼표_콜론구분자_RuntimeException() {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,-2:3"))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void 음수_커스텀구분자_RuntimeException() {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1;-2;3"))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void NaN_쉼표_콜론구분자_NumberFormatException() {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1:2,abcde"))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void NaN_커스텀구분자_NumberFormatException() {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1;2;abcde"))
        .isInstanceOf(NumberFormatException.class);
  }

}
