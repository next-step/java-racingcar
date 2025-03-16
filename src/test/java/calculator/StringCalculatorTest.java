package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
  void 음수() {
    assertThatThrownBy(() -> {
      calculate("-1,2,3");
    }).isInstanceOf(RuntimeException.class);
  }

  @Test
  @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0 반환")
  void 빈_공백문자() {
    assertThat(calculate(null)).isEqualTo(0);
    assertThat(calculate("")).isEqualTo(0);
  }

  @Test
  @DisplayName("//”와 “\n” 문자 사이에 커스텀 구분자를 지정")
  void 커스텀_구분자() {
    assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
    assertThat(calculate("//&\n1&2&3&4")).isEqualTo(10);
  }

  @Test
  @DisplayName("구분자 컴마(,) 콜론(:)을 사용할 경우 값 반환 테스트")
  void 컴마_콜론_구분자() {
    assertThat(calculate("1:2,3")).isEqualTo(6);
  }

  @Test
  @DisplayName("구분자 콜론(:)을 사용할 경우 값 반환 테스트")
  void 콜론_구분자() {
    assertThat(calculate("1:2")).isEqualTo(3);
  }

  @Test
  @DisplayName("구분자 컴마(,)를 사용할 경우 값 반환 테스트")
  void 컴마_구분자() {
    assertThat(calculate("1,2")).isEqualTo(3);
  }

  @Test
  @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
  void 숫자_하나() {
    assertThat(calculate("1")).isEqualTo(1);
  }
}
