package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
  @Test
  @DisplayName("\"1,2\"을 ,로 split 시켜서 1과 2로 분리되는지 확인")
  void split() {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1");
    assertThat(result).containsExactly("1","2");
  }

  @Test
  @DisplayName("data: \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
  void substring() {
    String data = "(1,2)";
    String result = data.substring(1,data.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
  void chartAt() {
    String data = "abc";
    char result = data.charAt(3);

    assertThat(result).isEqualTo('b');
//    assertThat(result).as("if result type char then you use '' ").isEqualTo('b');
  }

  @Test
  @DisplayName("chartAt() 요청한 인덱스가 타겟의 위치값을 벗어나면 StringIndexOutOfBoundsException 발생")
  void StringIndexOutOfBoundsExceptionIfDataMaxIndexLessThenIndex() {
    String data = "abc";

    assertThatThrownBy(() -> {
      data.charAt(data.length());
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range")
        .hasMessageContaining(String.valueOf(data.length()));
  }
}
