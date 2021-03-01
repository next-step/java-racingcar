package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

  String[] actual;

  @BeforeEach
  void setUp() {
    actual = "1,2".split(",");
  }

  @Test
  @DisplayName("actual이 1과 2를 포함하는지 테스트")
  void splitContains() {
    assertThat(actual).contains("1", "2");
  }

  @Test
  @DisplayName("actual이 1과 2를 순서대로 포함하고 있는지 확인하는 테스트")
  void splitContainsExactly() {
    assertThat(actual).containsExactly("1", "2");
  }
}
