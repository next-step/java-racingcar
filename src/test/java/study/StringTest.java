package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  @DisplayName("actual이 1과 2를 포함하는지 테스트")
  void splitContains() {
    String[] actual = "1,2".split(",");
    assertThat(actual).contains("1", "2");
  }

  @Test
  @DisplayName("actual이 1과 2를 순서대로 포함하고 있는지 확인하는 테스트")
  void splitContainsExactly() {
    String[] actual = "1,2".split(",");
    assertThat(actual).containsExactly("1", "2");
  }

  @Test
  @DisplayName("actual이 1을 포함하는지 테스트")
  void splitContainsOne() {
    String[] actual = "1".split(",");
    assertThat(actual).contains("1");
  }
}
