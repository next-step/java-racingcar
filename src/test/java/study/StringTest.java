package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("[요구사항 1-1] 1,2 split 테스트")
  void split() {
    String[] splitArr = "1,2".split(",");
    assertThat(splitArr).contains("1", "2");
    assertThat(splitArr).containsExactly("1", "2");
  }

  @Test
  @DisplayName("[요구사항 1-2] 1, split 테스트")
  void singleSplitTest() {
    String[] splitArr = "1".split(",");
    assertThat(splitArr).containsExactly("1");
  }

  @Test
  @DisplayName("[요구사항 2] (1,2) substring 테스트")
  void substringTest() {
    String substringStr = "(1,2)".substring(1, 4);
    assertThat(substringStr).isEqualTo("1,2");
  }

  @Test
  @DisplayName("[요구사항 3] abc charAt() 테스트")
  void stringCharAtTest() {
    String input = "abc";

    assertThat(input.charAt(0)).isEqualTo('a');
    assertThat(input.charAt(1)).isEqualTo('b');
    assertThat(input.charAt(2)).isEqualTo('c');

    assertThatThrownBy(() -> {
      input.charAt(4);
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 4");
  }
}