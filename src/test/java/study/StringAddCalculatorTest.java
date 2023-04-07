package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

  @DisplayName("빈문자열 또는 null을 전달하면 0을 반환한다.")
  @Test
  public void splitAndSum_0_NullOrEmpty() {
    assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
  }

  @DisplayName("하나의 숫자문자열을 전달하면 해당 숫자를 반환한다.")
  @Test
  public void splitAndSum_Int_OneNumber() throws Exception {
    assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
  }

  @DisplayName("쉼표로 구분된 숫자 문자열을 전달하면 해당 숫자의 합을 반환한다.")
  @Test
  public void splitAndSum_Int_쉼표Delimeters() throws Exception {
    assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
  }

  @DisplayName("콜론으로 구분된 숫자 문자열을 전달하면 해당 숫자의 합을 반환한다.")
  @Test
  public void splitAndSum_Int_콜론Delimeters() throws Exception {
    assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
  }

  @DisplayName("쉼표와 콜론으로 구분된 숫자 문자열을 전달하면 해당 숫자의 합을 반환한다.")
  @Test
  public void splitAndSum_Int_쉼표콜론Delimeters() throws Exception {
    assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
  }

  @DisplayName("custum구분자가 포함된 숫자 문자열을 전달하면 해당 숫자의 합을 반환한다.")
  @Test
  public void splitAndSum_Int_CustomDelimeters() throws Exception {
    assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    assertThat(StringAddCalculator.splitAndSum("//'\n1'2'3")).isEqualTo(6);
  }

  @DisplayName("음수가 포함된 숫자 문자열을 전달하면 RuntimeException이 발생한다.")
  @Test
  public void splitAndSum_ThrowsException_NegativeNumber() throws Exception {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("음수가 전달되었습니다.: " + -1);
  }
}
