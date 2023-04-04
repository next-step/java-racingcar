package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void requirement1() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");

    result = "1".split(",");
    assertThat(result).contains("1");
  }

}
