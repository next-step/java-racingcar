package String;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

  @Test
  public void splitTest1() {
    //given
    String string = "1,2";

    //when
    String[] split = string.split(",");

    //then
    assertThat(split).contains("1", "2");
  }

  @Test
  public void splitTest2() {
    //given
    String string = "1";

    //when
    String[] split = string.split(",");

    //then
    assertThat(split).containsExactly("1");
  }

  @Test
  public void subStringTest() {
    //given
    String string = "(1,2)";

    //when
    String result = string.substring(1, string.length() - 1);

    //then
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("특정위치의 문자열 가져오기")
  public void getCharacterWithPosition() {
    //given
    String string = "abc";

    //when
    char result1 = string.charAt(0);
    char result2 = string.charAt(1);
    char result3 = string.charAt(2);

    //then
    assertThat(result1).isEqualTo('a');
    assertThat(result2).isEqualTo('b');
    assertThat(result3).isEqualTo('c');
  }

  @Test
  @DisplayName("잘못된 위치의 문자열 가져오기")
  public void getCharacterWithWrongPosition() {
    //given
    String string = "abc";

    //when, then
    assertThatThrownBy(() -> {
      string.charAt(string.length() + 1);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
