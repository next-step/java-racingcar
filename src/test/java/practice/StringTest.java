package practice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {
  @Test
  public void splitTest() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");
  }

}
