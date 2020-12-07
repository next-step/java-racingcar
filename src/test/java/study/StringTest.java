package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split() {

    String[] result1 = "1,2".split(",");
    String[] result2 = "1".split(",");

    assertThat(result1).contains("1", "2");
    assertThat(result2).containsExactly("1");
    //assertThat(result1).contains("3");

    assertThat(getStringWithoutBracket("(1,2)")).isEqualTo("1,2");
  }

  String getStringWithoutBracket(String input) {

    return input.substring(1, input.length() - 1);
  }

  @Test
  @DisplayName("Exception test")
  void getCharAt() {

    String testString = "abc";

    assertThatThrownBy( () -> { testString.charAt(5);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
