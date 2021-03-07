package cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// 
import static org.assertj.core.api.Assertions.*;

public class StringTest {

  @Test
  @DisplayName("'1,2' 로 split 시 1, 2로 잘 분리되는지 테스트")
  public void splitTest1() {
    String[] str = "1,2".split(",");
    assertThat(str).contains("1");
    assertThat(str).containsExactly("1", "2");
  }

  @Test
  @DisplayName("'1' 로 split 시 1만 포함하는 배열이 반환되는지 테스트")
  public void splitTest2() {
    String[] str = "1".split(",");
    assertThat(str).contains("1");
    assertThat(str).doesNotContain("2");
  }

  @Test
  @DisplayName("'(1,2)' 값이 주어졌을 때 String 의 substring() 매소드를 활용해 () 을 제거하고 '1,2' 를 반환하도록 테스트")
  public void substringTest1() {
    String str = "(1,2)".substring(1, 4);
    assertThat(str).contains("1, 2");
  }

  @Test
  @DisplayName("abc 값이 주어졌을때 String 의 CharAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습을 테스트")
  public void charAtTest1() {
    char c = "abc".charAt(0);
    assertThat(c).isEqualTo('a');
  }

  @Test
  @DisplayName("charAt() 메소드 사용시 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생하는 부분 테스트")
  public void charAtTest2() {
    assertThatThrownBy(() -> {
      "abc".charAt(3);
    }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range");

  }
}
