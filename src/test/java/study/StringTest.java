package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

  @Test
  void split() {
    assertThat(split("1,2", ",")).containsExactly("1", "2");
    assertThat(split("1", ",")).containsExactly("1");
  }

  private String[] split(String str, String separator) {
    return str.split(separator);
  }
}
