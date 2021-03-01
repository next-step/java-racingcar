package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  @DisplayName("1,2를 split한 값이 1과 2를 포함하는지, 순서대로 포함하는지 확인")
  void splitContains() {
    String[] actual = "1,2".split(",");

    assertAll(
        () -> assertThat(actual).contains("1", "2"),
        () -> assertThat(actual).containsExactly("1", "2")
    );
  }

  @Test
  @DisplayName("actual이 1을 포함하는지 테스트")
  void splitContainsOne() {
    String[] actual = "1".split(",");

    assertThat(actual).contains("1");
  }
}
