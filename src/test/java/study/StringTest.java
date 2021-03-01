package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

  @Test
  void split(){
    assertThat("1,2".split(",")).contains("1");
  }

  @Test
  void splitOnlyOneValues(){
    String[] targetData = new String[]{"1"};

    assertThat("1".split(",")).isEqualTo(targetData);
  }

  @Test
  void substring(){
    String testStr = "(1,2)";

    assertThat(testStr.substring(1,testStr.length()-1)).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt을 사용했을 때 원하는 결과를 도출하는지 확인")
  void charAt(){
    String testStr = "abc";

    assertThat(testStr.charAt(0)).isEqualTo('a');
    assertThat(testStr.charAt(1)).isEqualTo('b');
    assertThat(testStr.charAt(2)).isEqualTo('c');
  }

  @Test
  @DisplayName("Index 범위를 벗어나는 위치 확인 시 StringIndexOutOfBoundsException 에러 호출 체크")
  void charAtOutOfBounds(){
    String testStr = "abc";

    assertThatThrownBy(()-> testStr.charAt(testStr.length()))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .withFailMessage("String Out of Memory : \\d");
  }
}
