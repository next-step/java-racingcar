package study.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
  public void split1() throws Exception {
    // given
    String input = "1,2";
    // when
    String[] result = input.split(",");
    // then
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
  public void split2() throws Exception {
    // given
    String input = "1";
    // when
    String[] result = input.split(",");
    // then
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
  public void split3() throws Exception {
    // given
    String input = "(1,2)";
    // when
    String[] result = input.substring(1, 4).split(",");
    // then
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
  public void split4() throws Exception {
    // given
    String input = "abc";
    // when
    int outOfIndex = input.length() + 1000;
    // then
    assertThatThrownBy(() -> {
      char result = input.charAt(input.length() + 1000);
    }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 1003");
  }

}
