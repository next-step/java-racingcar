package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

  int result;

  @Test
  void splictAndSum_null_또는_빈문자() {
    result = StringAddCalculator.splictAndSum(null);
    assertThat(result).isEqualTo(0);

    result = StringAddCalculator.splictAndSum("");
    assertThat(result).isEqualTo(0);
  }

  @Test
  void splictAndSum_숫자하나() {
    result = StringAddCalculator.splictAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  void splictAndSum_쉼표구분자() {
    result = StringAddCalculator.splictAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  void splictAndSum_쉼표_또는_콜론_구분자() {
    result = StringAddCalculator.splictAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  void splictAndSum_custom_구분자() {
    result = StringAddCalculator.splictAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  void splictAndSum_custom_negative() throws Exception {
    assertThatThrownBy(() -> StringAddCalculator.splictAndSum("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }
}