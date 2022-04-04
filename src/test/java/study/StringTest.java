package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
  @Test
  void split() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
  @Test
  void splitOne() {
    String[] result = "1".split(",");
    assertThat(result).containsExactly("1");
  }

  @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
  @Test
  void substring() {
    String result = "(1,2)".substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
  @Test
  void charAt() {

    assertThat("abc".charAt(0)).isEqualTo('a');
    assertThat("abc".charAt(1)).isEqualTo('b');
    assertThat("abc".charAt(2)).isEqualTo('c');
  }

  @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
  @Test
  void charAtThrowsException() {
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> "abc".charAt(3))
        .withMessageMatching("String index out of range: \\d+");
  }
}
