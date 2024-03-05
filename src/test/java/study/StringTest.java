package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split(){
    String[] result = "1,2".split(",");
    assertThat(result).contains("1");
  }

  @Test
  void substring(){
    String data = "(1,2)";
    String result = data.substring(1, data.length()-1);
    assertThat(result).isEqualTo("1,2");

    String result2 = data.substring(data.indexOf('(')+1, data.indexOf(')'));
    assertThat(result2).isEqualTo("1,2");
  }

  @DisplayName("charAt() test")
  @Test
  void charAt(){
    String data = "abc";
    assertThat(data.charAt(1)).isEqualTo('b');
  }

  @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생 test")
  @Test
  void charAtWithException(){
    String data = "abc";
    assertThatThrownBy(() -> data.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
