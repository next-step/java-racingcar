package caculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositiveOrZeroTest {

  @ParameterizedTest(name = "입력값: {0}")
  @ValueSource(ints = {1, 0})
  void 생성자_양수_또는_0(int input) {
    assertThat(new PositiveOrZero(input).value()).isEqualTo(input);
  }

  @Test
  void 생성자_음수() {
    assertThatThrownBy(() -> new PositiveOrZero(-1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -1");
  }

  @ParameterizedTest(name = "입력값: {0}")
  @ValueSource(strings = {"1", "0"})
  void 생성자_양수_또는_0_문자열(String input) {
    assertThat(new PositiveOrZero(input).value()).isEqualTo(Integer.parseInt(input));
  }

  @Test
  void 생성자_null() {
    assertThatThrownBy(() -> new PositiveOrZero(null)).isInstanceOf(NumberFormatException.class);
  }

  @ParameterizedTest(name = "입력값: [{0}]")
  @ValueSource(strings = {"a", " ", "", "1a", "a1"})
  void 생성자_숫자가_아닌_문자열(String input) {
    assertThatThrownBy(() -> new PositiveOrZero(input)).isInstanceOf(NumberFormatException.class);
  }

  @Test
  void 생성자_음수_문자열() {
    assertThatThrownBy(() -> new PositiveOrZero("-1"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -1");
  }

  @ParameterizedTest(name = "{0} + {1} = {2}")
  @CsvSource({"1, 2, 3", "0, 1, 1", "0, 0, 0"})
  void add_양수_또는_0(int a, int b, int expected) {
    assertThat(new PositiveOrZero(a).add(new PositiveOrZero(b)).value()).isEqualTo(expected);
  }

  @Test
  void add_null() {
    assertThatThrownBy(() -> new PositiveOrZero(1).add(null))
        .isInstanceOf(NullPointerException.class);
  }
}
