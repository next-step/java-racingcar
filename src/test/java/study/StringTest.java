package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {
  @Test
  void requirement_1() {
    Assertions.assertThat("1,2".split(",")).containsExactly("1", "2");
    Assertions.assertThat("1".split(",")).containsExactly("1");
  }

  @Test
  void requirement_2() {
    String testString = "(1,2)";
    String result = testString.substring(1, testString.length() - 1);
    Assertions.assertThat(result).isEqualTo("1,2");
  }

  @ParameterizedTest
  @CsvSource(value = {"0:a", "1:b", "2:c" }, delimiter = ':')
  @DisplayName("charAt은 인자로 주어진 값의 위치에 있는 character를 반환하며, 범위를 벗어날 시 StringIndexOutOfBoundsException 예외를 반환한다.")
  void requirement_3(int input, char expected) {
    String testString = "abc";
    Assertions.assertThat(testString.charAt(input)).isEqualTo(expected);
    Assertions.assertThatThrownBy(() -> testString.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
  }
}

