package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("String 구분자로 분리")
  void stringSplitTest() {
    assertThat("1,2".split(","))
        .containsExactly("1", "2");
  }

  @Test
  @DisplayName("String 구분자가 없는 경우")
  void stringSplitWithoutDelimiterTest() {
    assertThat("1".split(","))
        .containsExactly("1");
  }

  @Test
  @DisplayName("String 특정 구간 잘라내기")
  void stringSubstringTest() {
    assertThat("(1,2)".substring(1, 4))
        .isEqualTo("1,2");
  }

  @Test
  @DisplayName("String 특정 위치 문자 가져오기")
  void stringChartAtTest() {
    int validIndex = 1;
    assertThat("abc".charAt(validIndex))
        .isEqualTo('b');
  }

  @Test
  @DisplayName("String 특정 위치 문자 가져오기 예외발생")
  void stringChartAtThrowsExceptionTest() {
    int invalidIndex = 4;
    assertThatThrownBy(() -> "abc".charAt(invalidIndex))
        .isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
