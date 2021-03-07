package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringClassTest {

  @Test
  @DisplayName("split 테스트")
  void 요구사항1() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");

    String[] result2 = "1".split(",");
    assertThat(result2).contains("1");
  }

  public String 요구사항2(String input) {
    input = input.replaceAll(" ", "");
    return input.substring(1, input.length() - 1);
  }

  @Test
  @DisplayName("substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다")
  void 요구사항2_Test() {
    String result = 요구사항2("(1,2)");
    assertThat(result).isEqualTo("1,2");
    result = 요구사항2("(1,2) ");
    assertThat(result).isEqualTo("1,2");
    result = 요구사항2(" (1,2) ");
    assertThat(result).isEqualTo("1,2");
    result = 요구사항2(" (1, 2) ");
    assertThat(result).isEqualTo("1,2");
    result = 요구사항2(" (1, 2)          ");
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현하고 예외테스트를 한다")
  public void 요구사항3() {
    // given some preconditions
    String input = "abc";

    // when - success
    char result = input.charAt(0);
    assertThat(result).isEqualTo('a');

    // when - exception1
    Throwable thrown = catchThrowable(() -> { input.charAt(3); });

    // then
    assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");

    // exception2
    assertThatThrownBy(() -> {
      input.charAt(-1);
    }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
              input.charAt(-1);
            }).withMessageMatching("String index out of range: -1");
  }
}
