package com.cspark.nextstep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  private final String COMMA_DELIMITER = ",";

  @DisplayName("요구사항 1: split")
  @Test
  void split() {
    String[] strings = "1,2".split(COMMA_DELIMITER);
    assertThat(strings).contains("1");
    assertThat(strings).contains("2");
    assertThat(strings)
        .as("모든 배열 순서 검증")
        .containsExactly("1", "2");

    String[] ones = "1".split(COMMA_DELIMITER);
    assertThat(ones)
        .as("")
        .contains("1");
  }

  @DisplayName("요구사항 2: substring")
  @Test
  void substring() {
    String context = "(1,2)".substring(1, 4);
    assertThat(context)
        .as("beginIndex: inclusive, endIndex: exclusive")
        .isEqualTo("1,2");
  }

  @DisplayName("요구사항 3: charAt")
  @Test
  void charAt() {
    assertThat("abc".charAt(0)).isEqualTo('a');
    assertThat("abc".charAt(1)).isEqualTo('b');
    assertThat("abc".charAt(2)).isEqualTo('c');

    assertThatThrownBy(() -> "abc".charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
