package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split() {
    String[] result = "1,2".split (",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  void substring() {
    String data = "(1,2)";
    String result = "(1,2)".substring(1, data.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }


}
