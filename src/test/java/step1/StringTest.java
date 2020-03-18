package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
  private static final String splitCharacter = ",";

  private String[] splitByComma(String string) {
    return string.split(splitCharacter);
  }

  private String stripParenthesis(String string) {
    return string.substring(1, string.length() - 1);
  }

  @Test
  void testSplit() {
    String testValue1 = "1,2";
    String testValue2 = "1";

    String one = "1";
    String two = "2";

    assertThat(splitByComma(testValue1)).containsExactly(one, two);
    assertThat(splitByComma(testValue2)).containsExactly(one);
  }

  @Test
  void testSubstring() {
    String testValue = "(1,2)";

    String expectedValue = "1,2";

    assertThat(stripParenthesis(testValue)).isEqualTo(expectedValue);
  }

  @Test
  void testCharAt() {
    String testValue = "abc";

    char firstAlphabet = 'a';
    char secondAlphabet = 'b';
    char thirdAlphabet = 'c';
    String expectedErrorMessage = "String index out of range: 3";

    assertThat(testValue.charAt(0)).isEqualTo(firstAlphabet);
    assertThat(testValue.charAt(1)).isEqualTo(secondAlphabet);
    assertThat(testValue.charAt(2)).isEqualTo(thirdAlphabet);
    assertThatThrownBy(() -> testValue.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining(expectedErrorMessage);
  }
}
