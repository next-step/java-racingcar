package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName(",가 있는 문자열에서 ,를 기준으로 split 테스트")
  void split() {
    String[] result = "1,2".split (",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName(",가 없는 문자열에서 ,를 기준으로 split시 문자열 정상 반환 테스트")
  void split2() {
    String[] result = "1".split (",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("substring 테스트")
  void substring() {
    String data = "(1,2)";
    String result = "(1,2)".substring(1, data.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt()을 통해 index에 해당하는 문자열 반환 테스트")
  void charAt() {
    assertThat("abc".charAt(2)).isEqualTo('c');
  }

  @Test
  @DisplayName("charAt()시 위치 값을 벗어났을 경우 StringIndexOutOfBoundsException 발생 테스트")
  void StringIndexOutOfBoundsExceptionTest() {
    assertThatThrownBy(() -> {
      "abc".charAt(3);
    }).isInstanceOf(IndexOutOfBoundsException.class);
  }

}
