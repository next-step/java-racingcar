package practice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class StringTest {
  @Test
  public void splitTest() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  public void splitTest2() {
    String[] result = "1,".split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  public void substringTest() {
    String str = "(1,2)";
    String result = str.substring(1, str.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  public void charAtTest() {
    String str = "abc";
    assertThat(str.charAt(0)).isEqualTo('a');
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> str.charAt(5));
  }
}

