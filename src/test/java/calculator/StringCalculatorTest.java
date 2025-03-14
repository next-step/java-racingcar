package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  void String_숫자가_인식이_잘_된다() {
    assertThat(StringCalculator.calculate("1")).isEqualTo(1);
  }

  @Test
  void 빈문자열_혹_null은_0을_반환한다() {
    assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    assertThat(StringCalculator.calculate("")).isEqualTo(0);
  }

  @Test
  void 컴마구분자로_입력한_두_숫자는_합을_반환한다() {
    assertThat(StringCalculator.calculate("1,2,3")).isEqualTo(6);
  }

  @Test
  void 구분자를_입력받을_수_있다() {
    assertThat(StringCalculator.calculate("1,2,3", ",")).isEqualTo(6);
    assertThat(StringCalculator.calculate("1,2:3", ",|:")).isEqualTo(6);
  }
}
