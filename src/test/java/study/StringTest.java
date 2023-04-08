package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {


  @Test
  @DisplayName("1,2를 1과 2로 분리 테스트")
  void split() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("1을 ,로 split할 때 1만 포함되는 배열이 반환되는지 테스트")
  void splitOne() {
    String[] result = "1".split(",");

    assertThat(result)
            .contains("1")
            .hasSize(1);
  }

  @Test
  @DisplayName("(1,2)에서 () 제거 테스트")
  void substring() {
    String result = "(1,2)".substring(1, 4);

    assertThat(result)
            .isEqualTo("1,2")
            .doesNotContain("(", ")");
  }

  @ParameterizedTest
  @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
  @DisplayName("문자열 abc에서 특정 위치 문자 확인 테스트")
  void charAt(int index, char expected) {
    String abc = "abc";
    char charOfIndex = abc.charAt(index);

    assertThat(charOfIndex).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 4, 6, Integer.MAX_VALUE})
  @DisplayName("문자열 abc에서 위치값을 벗어나는 경우 StringIndexOutOfBoundsException 발생 테스트")
  void charAtRaiseStringIndexOutOfBoundsException(int index) {
    String abc = "abc";

    assertThatThrownBy(() -> abc.charAt(index))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: " + index);
  }
}
