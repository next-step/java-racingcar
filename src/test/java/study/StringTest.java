package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split() {
    String[] values = "1,2".split(",");
    assertThat(values).containsExactly("1", "2");
  }
}
