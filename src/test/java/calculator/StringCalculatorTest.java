package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @Test
  void 음수() {
    assertThatThrownBy(() -> {
      calculate("-1,2,3");
    }).isInstanceOf(RuntimeException.class);
  }

  @Test
  void 빈_공백문자() {
    assertThat(calculate(null)).isEqualTo(0);
    assertThat(calculate("")).isEqualTo(0);
  }

  @Test
  void 커스텀_구분자() {
    assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
    assertThat(calculate("//&\n1&2&3&4")).isEqualTo(10);
  }

  @Test
  void 컴마_콜론_구분자() {
    assertThat(calculate("1:2,3")).isEqualTo(6);
  }

  @Test
  void 콜론_구분자() {
    assertThat(calculate("1:2")).isEqualTo(3);
  }

  @Test
  void 컴마_구분자() {
    assertThat(calculate("1,2")).isEqualTo(3);
  }

  @Test
  void 숫자_하나() {
    assertThat(calculate("1")).isEqualTo(1);
  }
}
