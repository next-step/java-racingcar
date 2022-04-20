package camp.nextstep.calculator.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("[요구사항1-1] \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
  public void split() {
    final String input = "1,2";
    String[] result = input.split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("[요구사항1-2] \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
  public void split2() {
    final String input = "1";
    String[] result = input.split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("[요구사항2] \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.\n")
  public void substring() {
    final String input = "(1,2)";
    String result = input.substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("[요구사항3-1] 문자열의 특정위치에 문자를 반환한다.")
  public void charAt() {
    final String input = "abc";
    char result = input.charAt(1);
    assertThat(result).isEqualTo('b');
  }

  @Test
  @DisplayName("[요구사항3-2] 문자열 위치 값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생한다.")
  public void charAt_ThrowsStringIndexOutOfBoundsException() {
    assertThatThrownBy(() -> {
      final String input = "abc";
      input.charAt(4);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
