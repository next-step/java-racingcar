import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("요구사항1: 1,2 또는 1 을 , 로 split 했을 때 분리여부 확인")
  void splitTest() {
    String[] split12 = "1,2".split(",");
    assertThat(split12).containsExactly("1", "2");

    String[] split1 = "1".split(",");
    assertThat(split1).containsExactly("1");
  }

  @Test
  @DisplayName("요구사항2: (1,2) 의 () 제거 substring 확인")
  void substringTest() {
    String given = "(1,2)";
    String result = given.substring(1, given.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("요구사항3: abc 통해 charAt 메소드로 문자 가져오고, 범위 벗어났을 때 예외처리 확인")
  void charAtTest() {
    String given = "abc";

    char result = given.charAt(1);
    assertThat(result).isEqualTo('b');

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> given.charAt(3))
        .withMessageMatching("String index out of range: \\d+");
  }
}
