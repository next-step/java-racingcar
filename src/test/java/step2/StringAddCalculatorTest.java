package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringAddCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void 빈_문자열_공백문자_일때_0을_반환한다(String input) {
    assertThat(StringAddCalculator.spliteAndSum(input)).isEqualTo(0);
  }

  @Test
  void 문자열_하나를_숫자로_반환한다() {
    assertThat(StringAddCalculator.spliteAndSum("1")).isEqualTo(1);
  }

  @Test
  void 쉼표_구분자를_구분하고_합친다() {
    assertThat(StringAddCalculator.spliteAndSum("1,2")).isEqualTo(3);
  }

  @Test
  void 콜론_구분자를_구분하고_합친다() {
    assertThat(StringAddCalculator.spliteAndSum("1:2")).isEqualTo(3);
  }

  @Test
  void 커스텀_구분자를_구분하고_합친다() {
    assertThat(StringAddCalculator.spliteAndSum("//;\n1;2;3")).isEqualTo(6);
  }

  @Test
  void 음수를_전달할경우_예외를_발생한다() {
    assertThatThrownBy(() -> {
      StringAddCalculator.spliteAndSum("-1,2,3");
    }).isInstanceOf(RuntimeException.class);
  }

  @Test
  void 커스텀_구분자가_포함된_음수를_전달할경우_예외를_발생한다() {
    assertThatThrownBy(() -> {
      StringAddCalculator.spliteAndSum("//;\n1;2;-3");
    }).isInstanceOf(RuntimeException.class);
  }

  @Test
  void 숫자가_아닌_문자를_전달할경우_예외를_발생한다() {
    assertThatThrownBy(() -> {
      StringAddCalculator.spliteAndSum("//;\n1;2;a");
    }).isInstanceOf(NumberFormatException.class);
  }
}
