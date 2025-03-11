import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  public void test1_1() {
    var input = "1,2";
    var result = input.split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  public void test1_2() {
    var input = "1";
    var result = input.split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  public void test2() {
    var input = "(1,2)";
    var result = input.substring(1, input.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("주어진 문자열에서 특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
  public void test3() {
    var input = "abc";
    var point = 4;

    assertThatThrownBy(() -> {
      input.charAt(point);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
