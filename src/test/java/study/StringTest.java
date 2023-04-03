package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  public void split() throws Exception {
    // given
    String input = "1,2";
    // when
    String[] result = input.split(",");
    // then
    assertThat(result).contains("1");
  }

}
