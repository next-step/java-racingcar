package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;


public class StringTest {

  @Test
  @DisplayName("요구사항1-1: 1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
  void split_1() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("요구사항1-2: 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
  void split_2() {
    String[] result = "1".split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("요구사항2")
  void substring() {
    String result = "(1,2)".substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("요구사항3-1: 특정 위치의 문자 가져오는 테스트")
  void charAt_1() {
    String input = "abc";

    assertThat(input.charAt(0)).isEqualTo('a');
    assertThat(input.charAt(1)).isEqualTo('b');
    assertThat(input.charAt(2)).isEqualTo('c');

  }

  @Test
  @DisplayName("요구사항3-2: 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생 테스트")
  void charAt_2() {
    String input = "abc";

    assertThatThrownBy(() -> input.charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class);

  }


}
