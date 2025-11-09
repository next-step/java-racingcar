package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void empty_or_null_then_return_0(String input) throws Exception {
    assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
  }

  @Test
  void input검증_괄호() throws Exception {
    String clear = "(1,2)".substring(1, 4);
    assertThat(clear).isEqualTo("1,2");
  }

  @Test
  void find_특정위치문자() throws Exception {
    assertThat("(1,2)".charAt(1)).isEqualTo('1');
  }

  @Test
  @DisplayName("특정 위치 문자 삭제")
  void find_특정위치문자_throw_exception() throws Exception {
    String find = "(1,2)";
    assertThatThrownBy(() -> {
      find.charAt(find.length());
    }).isInstanceOf(Exception.class);
  }
}