package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringSumCalculatorTest {

  /** 요구사항 **
   쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
   (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
   앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
   커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
   예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
   문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
   */

  @Test
  void 커스텀구분자() {
    int sum = StringSumCalculator.sum("//#\n1#2#3");
    assertThat(sum).isEqualTo(6);
  }

  @Test
  void 쉼표와콜론구분자() {
    int sum = StringSumCalculator.sum("2,3:1");
    assertThat(sum).isEqualTo(6);
  }

  @Test
  void 쉼표구분자() {
    int sum = StringSumCalculator.sum("2,3");
    assertThat(sum).isEqualTo(5);

    sum = StringSumCalculator.sum("2,3,3");
    assertThat(sum).isEqualTo(8);
  }

  @Test
  void 숫자이외의값또는음수() {
    assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> StringSumCalculator.sum("ㄱ")).withMessageContaining("양수만");
    assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> StringSumCalculator.sum("-1")).withMessageContaining("양수만");
  }

  @Test
  void 숫자하나() {
    int sum = StringSumCalculator.sum("2");
    assertThat(sum).isEqualTo(2);
  }

  @Test
  void 공백또는빈문자() {
    int sum = StringSumCalculator.sum("");
    assertThat(sum).isEqualTo(0);

    sum = StringSumCalculator.sum(null);
    assertThat(sum).isEqualTo(0);
  }

  /**
   * nextstep 사이트 내의 TestCase 소스 코드
   */
  @Test
  public void splitAndSum_null_또는_빈문자() {
    int result = StringSumCalculator.sum(null);
    assertThat(result).isEqualTo(0);

    result = StringSumCalculator.sum("");
    assertThat(result).isEqualTo(0);
  }

  @Test
  public void splitAndSum_숫자하나() throws Exception {
    int result = StringSumCalculator.sum("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void splitAndSum_쉼표구분자() throws Exception {
    int result = StringSumCalculator.sum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
    int result = StringSumCalculator.sum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_custom_구분자() throws Exception {
    int result = StringSumCalculator.sum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> StringSumCalculator.sum("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }

}
