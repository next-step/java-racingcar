package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2021/03/02.
 * @project java-racingcar
 * @description
 */
public class StringTest {
  @DisplayName("요구사항1: split")
  @Test
  void split() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1","2");
  }

  @DisplayName("요구사항2: substring")
  @Test
  void substring() {
    String result = "(1,2)".substring(1,4);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("요구사항3: charAt")
  @Test
  void charAt() {
    String str = "abc";
    assertThatThrownBy(() -> str.charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
