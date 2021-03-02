package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
  @Test
  @DisplayName("콤마(,)로 나눠진 문자열을 분리함")
  public void splitArrayIntoTwoElements() {
    String[] result = "1,2".split(",");
    assertThat(result).contains("2", "1");
  }

  @Test
  @DisplayName("delimiter가 없는 문자열을 분리함")
  public void splitSingleElementArray() {
    String[] result = "1".split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("괄호로 감싸진 문자열의 분리함")
  public void splitArrayWithParentheses() {
    final String testData = "(1,2)";
    String result = testData.substring(1, testData.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("인덱스 번호를 넘어선 위치의 문자를 가져옴")
  public void getCharacterFromIndexOut() {
    final String testData = "abc";
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> testData.charAt(Integer.MAX_VALUE))
        .withMessageMatching("String index out of range: \\d+");
  }

}
