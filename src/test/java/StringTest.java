import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

  @Test
  @DisplayName("\"1,2\"를 ,로 split 했을 떄 [1,2]를 반환 ")
  public void stringSplitTestTwoElements() {
    String val = "1,2";
    String[] split = val.split(",");
    assertThat(split).contains("1", "2");
  }

  @Test
  @DisplayName("\"1\" 을 \",\"로 split 했을 떄 1만을 반환")
  public void stringSplitTestOneElement() {
    String val = "1";
    String[] split = val.split(",");
    assertThat(split).containsExactly("1");
  }

  @Test
  public void substringTest() {
    String val = "(1,2)";
    String substringVal = val.substring(1, val.length() - 1);
    assertThat(substringVal).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt 문자열 반환 Test")
  public void charAtThrowTest() {
    String val = "abc";
    assertThat(val.charAt(0)).isEqualTo('a');
    assertThat(val.charAt(1)).isEqualTo('b');
    assertThat(val.charAt(2)).isEqualTo('c');
  }

  @Test
  @DisplayName("charAt 문자열 위치 오류 Exception Throw Test")
  public void charAtThrowExceptionTest() {
    String val = "abc";
    assertThatThrownBy(() -> val.charAt(val.length()))
        .isInstanceOf(IndexOutOfBoundsException.class);
  }
}

