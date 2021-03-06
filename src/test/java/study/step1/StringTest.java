package study.step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
  void split_contains() {
    String input = "1,2";
    String[] result = input.split(",");
    assertThat(result).contains("1", "2");
  }

  @Test
  @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
  void split_containsExactly() {
    String input = "1";
    String[] result = input.split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
  void substring() {
    String input = "(1,2)";
    int beginIndex = input.indexOf("(") + 1;
    int endIndex = input.indexOf(")");
    String result = input.substring(beginIndex, endIndex);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.\n")
  void charAt() {
    String input = "abc";
    assertAll(
        () -> assertThat(input.charAt(0)).isEqualTo('a'),
        () -> assertThat(input.charAt(1)).isEqualTo('b'),
        () -> assertThat(input.charAt(2)).isEqualTo('c')
    );
  }

  @Test
  @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
  void charAt_OutOfBoundsException() {
    String input = "abc";
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> input.charAt(input.length() + 1))
        .withMessageMatching("String index out of range: \\d+");
  }
}
