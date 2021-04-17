package study.step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에대한 학습 테스트")
public class StringTest {

  @DisplayName("String 요구사항 1-1, 1과2로 분리")
  @Test
  void multipleSplit() {
    String[] multipleSplit = "1,2".split(",");
    assertThat(multipleSplit).containsExactly("1", "2");

    String[] singleSplit = "1".split(",");
    assertThat(singleSplit).containsExactly("1");
    assertThat(singleSplit.length).isEqualTo(1);
  }

  @DisplayName("String 요구사항 1-2, 1만 포함하는지")
  @Test
  void singleSplit() {
    String[] singleSplit = "1".split(",");
    assertThat(singleSplit).containsExactly("1");
    assertThat(singleSplit.length).isEqualTo(1);
  }

  @DisplayName("String 요구사항 2, 괄호 제거하여 1,2 반환")
  @Test
  void substringSplit() {
    String[] substringSplit = "(1,2)".substring(1, 4).split(",");
    assertThat(substringSplit).containsExactly("1", "2");
  }

  @DisplayName("String 요구사항 3, 특정위치 문자를 가져오기")
  @Test
  void stringCharAt() {
    String result = "abc";

    assertThat(result.charAt(0)).isEqualTo('a');

    assertThatThrownBy(() -> {
      result.charAt(3);
    }).isInstanceOf(IndexOutOfBoundsException.class);

  }

}
