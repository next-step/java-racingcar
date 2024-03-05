package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
  StringAddCalculator stringAddCalculator = new StringAddCalculator();

  @Test
  void null_입력() {
    assertThat(stringAddCalculator.calculate(null)).isEqualTo(0);
  }

  @Test
  void 빈_문자열_입력() {
    assertThat(stringAddCalculator.calculate("    ")).isEqualTo(0);
  }

  @Test
  void 숫자_하나() {
    assertThat(stringAddCalculator.calculate("1")).isEqualTo(1);
  }

  @Test
  void 숫자_두_개_커마() {
    assertThat(stringAddCalculator.calculate("1,2")).isEqualTo(3);
  }

  @Test
  void 숫자_두_개_콜론() {
    assertThat(stringAddCalculator.calculate("2:3")).isEqualTo(5);
  }

  @Test
  void 구분자_컴마_콜론_모두_사용() {
    assertThat(stringAddCalculator.calculate("1,2:3")).isEqualTo(6);
  }

  @ParameterizedTest
  @ValueSource(strings = { "-1:2", "3,-4", "-1,2:-3" })
  void 음수_포함된_경우_RuntimeException(String input) {
    assertThatThrownBy(() -> stringAddCalculator.calculate(input))
            .isInstanceOf(RuntimeException.class);
  }

  @ParameterizedTest()
  @ValueSource(strings = {"abc:2", "!@#:3", "4,$!@dd:5"})
  void 숫자_이외의_값_포함된_경우_RuntimeException(String input) {
    assertThatThrownBy(() -> stringAddCalculator.calculate(input))
            .isInstanceOf(RuntimeException.class);
  }
  
  @Test
  void 커스텀_구분자_사용() {
    assertThat(stringAddCalculator.calculate("//;\n1:2;3,4")).isEqualTo(10);
  }
}
