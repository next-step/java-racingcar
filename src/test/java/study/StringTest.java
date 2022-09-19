package study;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("집합 분리 테스트")
  void split() {

    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");

  }

}
